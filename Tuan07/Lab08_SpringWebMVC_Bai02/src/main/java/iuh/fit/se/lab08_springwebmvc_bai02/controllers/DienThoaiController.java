package iuh.fit.se.lab08_springwebmvc_bai02.controllers;

import iuh.fit.se.lab08_springwebmvc_bai02.models.DienThoai;
import iuh.fit.se.lab08_springwebmvc_bai02.models.NhaCungCap;
import iuh.fit.se.lab08_springwebmvc_bai02.services.DienThoaiService;
import iuh.fit.se.lab08_springwebmvc_bai02.services.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import jakarta.validation.Valid;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/dienthoai-jsp")
public class DienThoaiController {

    @Autowired
    private DienThoaiService dienThoaiService;

    @Autowired
    private NhaCungCapService nhaCungCapService;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @GetMapping("/list")
    public String showListPage(
            @RequestParam(name = "maNcc", required = false) Long maNcc,
            @RequestParam(name = "keywordNcc", required = false) String keywordNcc,
            Model model) {

        List<NhaCungCap> dsNhaCungCap;
        if (keywordNcc != null && !keywordNcc.trim().isEmpty()) {
            dsNhaCungCap = nhaCungCapService.search(keywordNcc);
        } else {
            dsNhaCungCap = nhaCungCapService.findAll();
        }
        model.addAttribute("dsNhaCungCap", dsNhaCungCap);
        model.addAttribute("keywordNcc", keywordNcc);

        List<DienThoai> dsDienThoai = null;
        if (maNcc != null) {
            dsDienThoai = dienThoaiService.findByNhaCungCapId(maNcc);
            NhaCungCap nccHienTai = nhaCungCapService.findById(maNcc).orElse(null);
            model.addAttribute("nccHienTai", nccHienTai);
        }
        model.addAttribute("dsDienThoai", dsDienThoai);

        return "DanhSachDienThoaiNCC";
    }

    @GetMapping("/showFormAdd")
    public String showFormAdd(Model model) {
        model.addAttribute("dienThoai", new DienThoai());
        model.addAttribute("dsNhaCungCap", nhaCungCapService.findAll());
        return "DienThoaiForm";
    }

    @PostMapping("/save")
    public String saveDienThoai(@Valid @ModelAttribute("dienThoai") DienThoai dienThoai,
                                BindingResult bindingResult,
                                @RequestParam("imageFile") MultipartFile imageFile,
                                Model model,
                                RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {
            model.addAttribute("dsNhaCungCap", nhaCungCapService.findAll());
            return "DienThoaiForm";
        }

        if (!imageFile.isEmpty()) {
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
                model.addAttribute("uploadError", "Lỗi upload hình ảnh: " + e.getMessage());
                model.addAttribute("dsNhaCungCap", nhaCungCapService.findAll());
                return "DienThoaiForm";
            }
        } else if (dienThoai.getMaDT() != 0) {
            dienThoaiService.findById(dienThoai.getMaDT())
                    .ifPresent(existingDt -> dienThoai.setHinhAnh(existingDt.getHinhAnh()));
        }


        DienThoai savedDienThoai = dienThoaiService.save(dienThoai);

        Long maNcc = null;
        if (savedDienThoai.getNhaCungCap() != null) {
            maNcc = savedDienThoai.getNhaCungCap().getMaNCC();
        }

        String redirectUrl = "redirect:/dienthoai-jsp/list";
        if (maNcc != null) {
            redirectUrl += "?maNcc=" + maNcc;
            redirectAttributes.addFlashAttribute("successMessage", "Lưu điện thoại thành công!");
        } else {
            redirectAttributes.addFlashAttribute("warningMessage", "Lưu điện thoại thành công nhưng không tìm thấy nhà cung cấp.");
        }

        return redirectUrl;
    }


    @GetMapping("/showFormUpdate")
    public String showFormUpdate(@RequestParam("id") long id, Model model) {
        Optional<DienThoai> optDienThoai = dienThoaiService.findById(id);
        if (optDienThoai.isPresent()) {
            model.addAttribute("dienThoai", optDienThoai.get());
            model.addAttribute("dsNhaCungCap", nhaCungCapService.findAll());
            return "DienThoaiForm";
        } else {
            return "redirect:/dienthoai-jsp/list";
        }
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") long id,
                                 @RequestParam(name = "maNcc", required = false) Long maNcc) {
        try {
            dienThoaiService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String redirectUrl = "redirect:/dienthoai-jsp/list";
        if (maNcc != null) {
            redirectUrl += "?maNcc=" + maNcc;
        }
        return redirectUrl;
    }

}