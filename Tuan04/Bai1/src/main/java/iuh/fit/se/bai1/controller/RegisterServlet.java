package iuh.fit.se.bai1.controller;

import iuh.fit.se.bai1.model.dao.UserDao;
import iuh.fit.se.bai1.model.dao.impl.UserImpl;
import iuh.fit.se.bai1.model.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/registration")
public class RegisterServlet extends HttpServlet {
    private UserDao userDao = new UserImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String reEmail = req.getParameter("reEmail");
        String password = req.getParameter("password");
        String gd = req.getParameter("gender");
        boolean gender;
        if("Male".equals(gd)){
            gender = true;
        } else {
            gender = false;
        }
        int day = Integer.parseInt(req.getParameter("day"));
        int month = Integer.parseInt(req.getParameter("month"));
        int year = Integer.parseInt(req.getParameter("year"));
        LocalDate birthday = LocalDate.of(year, month, day);

        if (!reEmail.equals(email)) {
            return;
        }
        User user = new User(firstName, lastName, email, password, birthday, gender);

        try {
            userDao.save(user);
            List<User> userList = userDao.findAll();
            req.setAttribute("userList", userList);
            req.getRequestDispatcher("/userList.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
