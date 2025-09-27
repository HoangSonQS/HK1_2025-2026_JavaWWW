package iuh.fit.se.bai3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryUtil {
    private static final EntityManagerFactory emf;
    static {
        try {
            emf = Persistence.createEntityManagerFactory("quanlydanhmuc-management");
        } catch (Throwable e) {
            System.err.println(e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void closeEntityManager() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
