package com.kiber.hibernate.jsf.utils;

import com.google.common.base.Function;
import com.kiber.hibernate.jsf.dao.entity.GenericEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by sirkleber on 13/05/16.
 */
public class JpaUtils {
    public final static String PU = "org.hibernate.tutorial.jpa";
    private final EntityManagerFactory emf;

    public static JpaUtils entityManager(){
        return new JpaUtils();
    }

    private JpaUtils(){
        emf = Persistence.createEntityManagerFactory(PU);
    }

    public <A extends GenericEntity> A execute(Function<EntityManager, A> f){
        final EntityManager em = emf.createEntityManager();
        final EntityTransaction et = em.getTransaction();

        et.begin();

        A res = f.apply(em);

        et.commit();

        em.close();
        emf.close();

        return res;
    }

    public void  insertOrUpdate(Function<EntityManager, Void> f){
        final EntityManager em = emf.createEntityManager();
        final EntityTransaction et = em.getTransaction();

        et.begin();

        f.apply(em);

        et.commit();

        em.close();
        emf.close();
    }
}