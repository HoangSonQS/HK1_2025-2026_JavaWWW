package iuh.fit.se.bai3.controller;

import iuh.fit.se.bai3.dao.TinTucDao;
import iuh.fit.se.bai3.dao.impl.TinTucImpl;
import iuh.fit.se.bai3.model.TinTuc;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/danhsach")
public class DanhSachTinTucServlet extends HttpServlet {
    private TinTucDao tinTucDao;

    public void init() {
        tinTucDao = new TinTucImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TinTuc> danhSach = tinTucDao.getAllTT();
        req.setAttribute("danhSachTinTuc", danhSach);
        req.getRequestDispatcher("view/DanhSachTinTuc.jsp").forward(req, resp);
    }
}
