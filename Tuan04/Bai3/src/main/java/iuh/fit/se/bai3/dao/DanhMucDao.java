package iuh.fit.se.bai3.dao;

import iuh.fit.se.bai3.model.DanhMuc;

import java.util.List;

public interface DanhMucDao {
    List<DanhMuc> layTatCaDanhMuc();
    DanhMuc layDanhMucTheoMaDM(long maDM);

}
