package iuh.fit.se.bai3.dao.impl;

import iuh.fit.se.bai3.EntityManagerFactoryUtil;
import iuh.fit.se.bai3.dao.TinTucDao;
import iuh.fit.se.bai3.model.TinTuc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class TinTucImpl implements TinTucDao {

    @Override
    public boolean themTinTuc(TinTuc tinTuc) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.persist(tinTuc);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (tr!=null && tr.isActive()) {
                tr.rollback();
            }
        }
        return false;
    }

    @Override
    public boolean xoaTinTuc(long maTT) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            TinTuc tinTuc = em.find(TinTuc.class, maTT);
            if (tinTuc != null) {
                em.remove(tinTuc);
            }
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (tr!=null && tr.isActive()) {
                tr.rollback();
            }
        }
        return false;
    }

    @Override
    public List<TinTuc> getAllTT() {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            return em.createQuery("SELECT t from TinTuc t", TinTuc.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TinTuc layTinTucTheoMa(long maTT) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        try {
            return em.find(TinTuc.class, maTT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
