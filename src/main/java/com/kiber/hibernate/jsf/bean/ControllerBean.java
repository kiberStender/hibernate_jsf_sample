package com.kiber.hibernate.jsf.bean;

import com.google.common.base.Function;
import com.kiber.hibernate.jsf.dao.entity.*;
import com.kiber.hibernate.jsf.utils.JpaUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by sirkleber on 12/05/16.
 */
@ManagedBean
@SessionScoped
public class ControllerBean {
    private AccUser user;

    @PostConstruct
    public void init(){
        user = new AccUser();
    }

    public void insertUser(ActionEvent e){

        final AccUser accUser = new AccUser("kleber.stender", "kleber.stender@gmail");
        final AccountType at = new AccountType("", accUser, "Wallet", "15", "Wallet");
        final TransactionType tt = new TransactionType("", "AV");
        final Item item = new Item("", tt, at, accUser, "Trip To Camboriu", 539.3, new Date());
        final Balance balance = new Balance("", at, accUser, 1000.0, 1000.0, new Date());

        JpaUtils.entityManager().insertOrUpdate(new Function<EntityManager, Void>() {
            @Override
            public Void apply(EntityManager entityManager) {
                entityManager.merge(item);
                entityManager.merge(balance);
                return null;
            }
        });

    }

    public void getUser(ActionEvent e){
        user = JpaUtils.entityManager().execute(new Function<EntityManager, AccUser>() {
            @Override
            public AccUser apply(EntityManager entityManager) {
                try {
                    return entityManager.createQuery("Select au from AccUser au where au.accUserId = 'kleber.stender'", AccUser.class).getSingleResult();
                } catch (NoResultException nre){
                    System.out.print(nre.getMessage());
                    return new AccUser("No User", "No email");
                }
            }
        });
    }

    public void createDb(ActionEvent e){
        Persistence.generateSchema(JpaUtils.PU, null);
    }

    public AccUser getUser() {
        return user;
    }

    public void setUser(AccUser user) {
        this.user = user;
    }
}
