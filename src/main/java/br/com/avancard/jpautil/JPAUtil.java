package br.com.avancard.jpautil;


import jakarta.persistence.EntityManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class JPAUtil {

    private static EntityManagerFactory factory = null;

    static {
        if (factory == null)
            factory = (EntityManagerFactory) Persistence.createEntityManagerFactory("myfirstprojectjsf");
    }
    public static EntityManager getEntityManager(){
        return (EntityManager) factory.createEntityManager();
    }

    public static Object getPrimaryKey(Object entity) {
        return factory.getPersistenceUnitUtil().getIdentifier(entity);
    }

}
