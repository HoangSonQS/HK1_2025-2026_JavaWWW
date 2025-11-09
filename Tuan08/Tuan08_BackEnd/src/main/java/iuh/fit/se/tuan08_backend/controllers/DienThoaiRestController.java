package iuh.fit.se.tuan08_backend.controllers;

import iuh.fit.se.tuan08_backend.models.DienThoai;
import iuh.fit.se.tuan08_backend.models.NhaCungCap;
import iuh.fit.se.tuan08_backend.services.DienThoaiService;
import iuh.fit.se.tuan08_backend.services.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class DienThoaiRestController {

    @Autowired
    private DienThoaiService dienThoaiService;

    @Autowired
    private NhaCungCapService nhaCungCapService;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @GetMapping("/nhacungcap")
    public ResponseEntity<List<NhaCungCap>> getDsNhaCungCap(
            @RequestParam(name = "keyword", required = false) String keyword) {
        List<NhaCungCap> dsNhaCungCap;
        if (keyword != null && !keyword.trim().isEmpty()) {
            dsNhaCungCap = nhaCungCapService.search(keyword);
        } else {
            dsNhaCungCap = nhaCungCapService.findAll();
        }
        return ResponseEntity.ok(dsNhaCungCap);
    }

    @GetMapping("/dienthoai/ncc/{maNcc}")
    public ResponseEntity<List<DienThoai>> getDienThoaiByNcc(@PathVariable Long maNcc) {
        List<DienThoai> dsDienThoai = dienThoaiService.findByNhaCungCapId(maNcc);
        return ResponseEntity.ok(dsDienThoai);
    }

    @GetMapping("/dienthoai/{id}")
    public ResponseEntity<DienThoai> getDienThoaiById(@PathVariable long id) {
        Optional<DienThoai> dienThoai = dienThoaiService.findById(id);
        return dienThoai.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/dienthoai")
    public ResponseEntity<?> saveDienThoai(
            @RequestPart("dienThoai") DienThoai dienThoai, // Nhận DienThoai dưới dạng JSON/part
            @RequestPart(value = "imageFile", required = false) MultipartFile imageFile) {

        if (imageFile != null && !imageFile.isEmpty()) {
            try {
                Path uploadPath = Paths.get(uploadDir);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                String uniqueFileName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();
                Path filePath = uploadPath.resolve(uniqueFileName);
                try (InputStream inputStream = imageFile.getInputStream()) {
                    Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                }
                dienThoai.setHinhAnh(uniqueFileName);
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Lỗi upload hình ảnh: " + e.getMessage());
            }
        } else if (dienThoai.getMaDT() != 0) {
            dienThoaiService.findById(dienThoai.getMaDT())
                    .ifPresent(existingDt -> dienThoai.setHinhAnh(existingDt.getHinhAnh()));
        }

        DienThoai savedDienThoai = dienThoaiService.save(dienThoai);
        return ResponseEntity.ok(savedDienThoai);
    }

    @DeleteMapping("/dienthoai/{id}")
    public ResponseEntity<String> deleteDienThoai(@PathVariable long id) {
        try {
            dienThoaiService.deleteById(id);
            return ResponseEntity.ok("Xóa thành công điện thoại ID: " + id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Lỗi khi xóa: " + e.getMessage());
        }
    }
}