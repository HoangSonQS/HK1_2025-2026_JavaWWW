package iuh.fit.se.tuan08_frontend.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import iuh.fit.se.tuan08_frontend.model.DienThoai;
import iuh.fit.se.tuan08_frontend.model.NhaCungCap;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@WebServlet(urlPatterns = {"/dienthoai", "/dienthoai/delete"})
public class DienThoaiServlet extends HttpServlet {
    private static final String BACKEND_API_URL = "http://localhost:8082/api";
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Xử lý xóa điện thoại
        if (request.getRequestURI().endsWith("/delete")) {
            handleDelete(request, response);
            return;
        }
        
        String keyword = request.getParameter("keywordNcc");
        String maNccParam = request.getParameter("maNcc");
        
        try {
            // Load danh sách Nhà Cung Cấp
            List<NhaCungCap> dsNhaCungCap = loadNhaCungCap(keyword);
            request.setAttribute("dsNhaCungCap", dsNhaCungCap);
            
            // Nếu có maNcc, load danh sách điện thoại
            if (maNccParam != null && !maNccParam.trim().isEmpty()) {
                try {
                    long maNcc = Long.parseLong(maNccParam);
                    List<DienThoai> dsDienThoai = loadDienThoaiByNcc(maNcc);
                    request.setAttribute("dsDienThoai", dsDienThoai);
                    request.setAttribute("selectedMaNcc", maNcc);
                    
                    // Tìm tên NCC được chọn
                    String tenNcc = dsNhaCungCap.stream()
                            .filter(ncc -> ncc.getMaNCC() == maNcc)
                            .map(NhaCungCap::getTenNhaCC)
                            .findFirst()
                            .orElse("Nhà Cung Cấp");
                    request.setAttribute("selectedTenNcc", tenNcc);
                } catch (NumberFormatException e) {
                    request.setAttribute("error", "Mã nhà cung cấp không hợp lệ");
                }
            }
            
            // Forward đến JSP
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/DanhSachDienThoaiNCC.jsp");
            dispatcher.forward(request, response);
            
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Lỗi khi tải dữ liệu: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/DanhSachDienThoaiNCC.jsp");
            dispatcher.forward(request, response);
        }
    }

    private List<NhaCungCap> loadNhaCungCap(String keyword) throws IOException, InterruptedException {
        String url = BACKEND_API_URL + "/nhacungcap";
        if (keyword != null && !keyword.trim().isEmpty()) {
            url += "?keyword=" + java.net.URLEncoder.encode(keyword, "UTF-8");
        }
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        
        if (response.statusCode() == 200) {
            return objectMapper.readValue(response.body(), new TypeReference<List<NhaCungCap>>() {});
        } else {
            throw new IOException("Lỗi khi gọi API: " + response.statusCode());
        }
    }

    private List<DienThoai> loadDienThoaiByNcc(long maNcc) throws IOException, InterruptedException {
        String url = BACKEND_API_URL + "/dienthoai/ncc/" + maNcc;
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        
        if (response.statusCode() == 200) {
            return objectMapper.readValue(response.body(), new TypeReference<List<DienThoai>>() {});
        } else {
            throw new IOException("Lỗi khi gọi API: " + response.statusCode());
        }
    }

    private void handleDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        String maNccParam = request.getParameter("maNcc");
        
        if (idParam == null || idParam.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Thiếu tham số id");
            return;
        }
        
        try {
            long id = Long.parseLong(idParam);
            String url = BACKEND_API_URL + "/dienthoai/" + id;
            
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .DELETE()
                    .build();
            
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            
            if (httpResponse.statusCode() == 200 || httpResponse.statusCode() == 204) {
                // Redirect về trang danh sách với maNcc nếu có
                String redirectUrl = request.getContextPath() + "/views/dienthoai";
                if (maNccParam != null && !maNccParam.trim().isEmpty()) {
                    redirectUrl += "?maNcc=" + maNccParam;
                }
                response.sendRedirect(redirectUrl);
            } else {
                request.setAttribute("error", "Lỗi khi xóa điện thoại: " + httpResponse.statusCode());
                doGet(request, response);
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID không hợp lệ");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Lỗi khi xóa: " + e.getMessage());
            doGet(request, response);
        }
    }
}

