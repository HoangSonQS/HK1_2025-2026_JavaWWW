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

@WebServlet("/quanly")
public class QuanLyFormServlet extends HttpServlet {
    private TinTucDao tinTucDao;

    @Override
    public void init() throws ServletException {
        tinTucDao = new TinTucImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TinTuc> danhSach = tinTucDao.getAllTT();
        req.setAttribute("danhSachTinTuc", danhSach);
        req.getRequestDispatcher("view/QuanLyForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maTTParam = req.getParameter("maTT");
        if (maTTParam != null && !maTTParam.isEmpty()) {
            try {
                long maTT = Long.parseLong(maTTParam);
                TinTucDao tinTucDao = new TinTucImpl();
                tinTucDao.xoaTinTuc(maTT);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        resp.sendRedirect("quanly");
    }
}
