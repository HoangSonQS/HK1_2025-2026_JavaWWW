package iuh.fit.se.bai3.dao;

import iuh.fit.se.bai3.model.TinTuc;

import java.util.List;

public interface TinTucDao {
    boolean themTinTuc(TinTuc tinTuc);
    boolean xoaTinTuc(long maTT);
    List<TinTuc> getAllTT();
    TinTuc layTinTucTheoMa(long maTT);
}
