package iuh.fit.se.bai2_jsp_mvc.servlets;

import iuh.fit.se.bai2_jsp_mvc.models.User;
import iuh.fit.se.bai2_jsp_mvc.services.UserService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/user-list", loadOnStartup = 1)
public class UserListServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<User> userList = userService.getAllUsers();

            req.setAttribute("userList", userList);

            req.getRequestDispatcher("/userList.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("error", "Lỗi khi tải dữ liệu từ cơ sở dữ liệu: " + e.getMessage());
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }
}