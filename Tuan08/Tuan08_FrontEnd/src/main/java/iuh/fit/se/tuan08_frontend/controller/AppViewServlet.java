package iuh.fit.se.tuan08_frontend.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/views/*")
public class AppViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pathInfo = request.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            response.sendRedirect(request.getContextPath() + "/views/dienthoai");
            return;
        }

        String jspPage = null;

        switch (pathInfo) {
            case "/dienthoai":
                jspPage = "DanhSachDienThoaiNCC";
                break;
            case "/dienthoai/form":
                jspPage = "DienThoaiForm";
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Trang không tồn tại");
                return;
        }

        String fullJspPath = "/WEB-INF/views/" + jspPage + ".jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(fullJspPath);
        dispatcher.forward(request, response);
    }
}