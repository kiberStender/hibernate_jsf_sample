package com.kiber.hibernate.jsf.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sirkleber on 12/05/16.
 */
@Entity
@Table(name = "accuser")
public class AccUser implements Serializable, GenericEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "accuserid")
    private String accUserId;
    @Column(name = "usermail")
    private String userMail;

    @OneToMany(mappedBy = "accUser", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<AccountType> accounts;

    public AccUser(String accUserId, String userMail, List<AccountType> accounts) {
        this.accUserId = accUserId;
        this.userMail = userMail;
        this.accounts = accounts;
    }

    public AccUser(String accUserId, String userMail) {
        this.accUserId = accUserId;
        this.userMail = userMail;
        accounts = new ArrayList<>();
    }

    public AccUser() {
        accounts = new ArrayList<>();
    }

    public String getAccUserId() {
        return accUserId;
    }

    public void setAccUserId(String accUserId) {
        this.accUserId = accUserId;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public List<AccountType> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountType> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccUser accUser = (AccUser) o;

        if (!accUserId.equals(accUser.accUserId)) return false;
        if (!userMail.equals(accUser.userMail)) return false;
        return accounts.equals(accUser.accounts);

    }

    @Override
    public int hashCode() {
        int result = accUserId.hashCode();
        result = 31 * result + userMail.hashCode();
        result = 31 * result + accounts.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AccUser{" +
                "accUserId='" + accUserId + '\'' +
                ", userMail='" + userMail + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
