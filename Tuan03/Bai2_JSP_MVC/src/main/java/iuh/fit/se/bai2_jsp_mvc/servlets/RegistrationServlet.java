package iuh.fit.se.bai2_jsp_mvc.servlets;

import iuh.fit.se.bai2_jsp_mvc.models.User;
import iuh.fit.se.bai2_jsp_mvc.services.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    // Đây là nơi bạn sẽ lưu danh sách các người dùng đã đăng ký
    private List<User> userList = new ArrayList<>();
    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String reEmail = req.getParameter("reEmail");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");

        int day = Integer.parseInt(req.getParameter("day"));
        int month = Integer.parseInt(req.getParameter("month"));
        int year = Integer.parseInt(req.getParameter("year"));
        LocalDate birthdate = LocalDate.of(year, month, day);

        if(!email.equals(reEmail))
            return;

        User newUser = new User(firstName, lastName, email, password, birthdate, gender);

        try {
            userService.addUser(newUser);
            List<User> userList = userService.getAllUsers();
            req.setAttribute("userList", userList);
            req.getRequestDispatcher("/userList.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("error", "Lỗi khi lưu dữ liệu: " + e.getMessage());
        }
    }
}
