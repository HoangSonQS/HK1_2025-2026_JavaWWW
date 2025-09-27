package iuh.fit.se.bai3.dao.impl;

import iuh.fit.se.bai3.EntityManagerFactoryUtil;
import iuh.fit.se.bai3.dao.DanhMucDao;
import iuh.fit.se.bai3.model.DanhMuc;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DanhMucImpl implements DanhMucDao {

    public DanhMucImpl() {
    }

    @Override
    public List<DanhMuc> layTatCaDanhMuc() {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        try {
            return em.createQuery("SELECT dm FROM DanhMuc dm", DanhMuc.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public DanhMuc layDanhMucTheoMaDM(long maDM) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        try {
            return em.find(DanhMuc.class, maDM);
        } finally {
            em.close();
        }
    }
}
