package iuh.fit.se.bai1.model.dao.impl;

import iuh.fit.se.bai1.EntityManagerFactoryUtil;
import iuh.fit.se.bai1.model.dao.UserDao;
import iuh.fit.se.bai1.model.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class UserImpl implements UserDao {
    private EntityManager em;

    public UserImpl() {
        em = EntityManagerFactoryUtil.getEntityManager();
    }


    @Override
    public User save(User user) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.persist(user);
            tr.commit();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            if (tr!=null && tr.isActive()) {
                tr.rollback();
            }
        }
        return null;
    }

    @Override
    public User update(User user) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.merge(user);
            tr.commit();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            if (tr!=null && tr.isActive()) {
                tr.rollback();
            }
        }
        return null;
    }

    @Override
    public boolean delete(String userId) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            User user = em.find(User.class, Long.valueOf(userId));
            if (user != null) {
                em.remove(user);
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
    public User findById(String userId) {
        EntityTransaction tr = em.getTransaction();
        try {
            User user = em.find(User.class, Long.valueOf(userId));
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            if (tr!=null && tr.isActive()) {
                tr.rollback();
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        EntityTransaction tr = em.getTransaction();
        try {
            return em.createQuery("select u from User u", User.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
