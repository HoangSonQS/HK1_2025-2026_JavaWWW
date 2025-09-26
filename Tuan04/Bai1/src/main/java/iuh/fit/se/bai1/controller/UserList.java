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
import java.util.List;

@WebServlet(urlPatterns = "/userList", loadOnStartup = 1)
public class UserList extends HttpServlet {
    private UserDao userDao = new UserImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<User> users = userDao.findAll();
            req.setAttribute("userList", users);
            req.getRequestDispatcher("/userList.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
