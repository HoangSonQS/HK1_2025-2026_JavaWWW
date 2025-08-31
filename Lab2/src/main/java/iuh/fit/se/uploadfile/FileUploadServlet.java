package iuh.fit.se.uploadfile;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@WebServlet(name = "fileUploadServlet", urlPatterns = {"/file-upload"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 MB Nếu kích thước file upload lơn hơn threshold sẽ được ghi trực tiếp vào ổ đĩa thay vì lưu ở memory đệm.
        maxFileSize = 1024 * 1024 * 5, // 5 MB Kích thước tối da của file được upload.
        maxRequestSize = 1024 * 1024 * 10 // 10 MB Kích thước tối đa cho một request.
)
public class FileUploadServlet extends HttpServlet {

    private String uploadPath = "/uploads";
    private String uploadToSource;
    private String uploadToTarget;
    @Override
    public void init() throws ServletException {
        String userDir = System.getProperty("user.dir");
        if (userDir.contains("tomcat") && userDir.endsWith("bin")) {
            userDir = new File(userDir).getParent();
        }
        uploadToSource = "D:\\HK1_2025-2026\\Java_WWW\\ExerciseLab\\Lab2\\src\\main\\webapp\\uploads";
        File uploadToSourseDir = new File(uploadToSource);
        if (!uploadToSourseDir.exists()) {
            uploadToSourseDir.mkdirs();
        }

        uploadToTarget = this.getServletContext().getRealPath("/uploads");

        File uploadToTargetDir = new File(uploadToTarget);
        if (!uploadToTargetDir.exists()) {
            uploadToTargetDir.mkdirs();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Part filePart : req.getParts()) {

            if (filePart == null || filePart.getSubmittedFileName() == null || filePart.getSubmittedFileName().isEmpty()) {
                continue;
            }

            String fileName = filePart.getSubmittedFileName();

            // Save the file to the server (using Files.copy)
            InputStream inputStream = filePart.getInputStream();
            Files.copy(inputStream, Paths.get(uploadToSource + File.separator + fileName),
                    StandardCopyOption.REPLACE_EXISTING);

            Files.copy(inputStream, Paths.get(uploadToTarget + File.separator + fileName),
                    StandardCopyOption.REPLACE_EXISTING);

            System.out.println(uploadPath + File.separator + fileName);
        }
    }
}
