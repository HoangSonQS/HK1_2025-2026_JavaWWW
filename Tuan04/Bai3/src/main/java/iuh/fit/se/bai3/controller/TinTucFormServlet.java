package iuh.fit.se.bai3.controller;

import iuh.fit.se.bai3.dao.DanhMucDao;
import iuh.fit.se.bai3.dao.TinTucDao;
import iuh.fit.se.bai3.dao.impl.DanhMucImpl;
import iuh.fit.se.bai3.dao.impl.TinTucImpl;
import iuh.fit.se.bai3.model.DanhMuc;
import iuh.fit.se.bai3.model.TinTuc;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
@WebServlet("/them")
public class TinTucFormServlet extends HttpServlet {
    private TinTucDao tinTucDao;
    private DanhMucDao danhMucDao;

    @Override
    public void init() throws ServletException {
        tinTucDao = new TinTucImpl();
        danhMucDao = new DanhMucImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DanhMuc> danhSachDanhMuc = danhMucDao.layTatCaDanhMuc();
        req.setAttribute("danhSachDanhMuc", danhSachDanhMuc);
        req.getRequestDispatcher("view/TinTucForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String tieuDe = req.getParameter("tieuDe");
        String noiDungTT = req.getParameter("noiDungTT");
        String lienKet = req.getParameter("lienKet");
        long maDM = Long.parseLong(req.getParameter("maDM"));

        DanhMuc danhMuc = danhMucDao.layDanhMucTheoMaDM(maDM);
        TinTuc tinTuc = new TinTuc(tieuDe, noiDungTT, lienKet, danhMuc);
        tinTucDao.themTinTuc(tinTuc);

        resp.sendRedirect("danhsach");
    }
}
