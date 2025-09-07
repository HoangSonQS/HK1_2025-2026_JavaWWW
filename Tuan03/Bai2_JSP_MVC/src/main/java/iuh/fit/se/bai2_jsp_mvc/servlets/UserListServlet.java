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
    private List<User> userList = new ArrayList<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            // Tải dữ liệu từ database một lần duy nhất khi Servlet khởi tạo
            userList = userService.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Lỗi khi tải dữ liệu từ database khi khởi tạo Servlet.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Sử dụng danh sách đã được tải sẵn
        req.setAttribute("userList", userList);
        req.getRequestDispatcher("/userList.jsp").forward(req, resp);
    }
}