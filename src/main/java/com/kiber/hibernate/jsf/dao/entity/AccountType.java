package com.kiber.hibernate.jsf.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sirkleber on 12/05/16.
 */
@Entity
@Table(name = "accounttype")
public class AccountType implements Serializable, GenericEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "acctypeid")
    private String accTypeId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "accuserid")
    private AccUser accUser;

    @Column(name = "description")
    private String description;

    @Column(name = "closingday")
    private String closingDay;

    @Column(name = "accmame")
    private String accName;

    @OneToMany(mappedBy = "acctype", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<Item> items;

    @OneToMany(mappedBy = "accountType", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<Balance> balances;

    public AccountType(String accTypeId, AccUser accUser, String description, String closingDay, String accName, List<Item> items, List<Balance> balances) {
        this.accTypeId = accTypeId;
        this.accUser = accUser;
        this.description = description;
        this.closingDay = closingDay;
        this.accName = accName;
        this.items = items;
        this.balances = balances;
    }

    public AccountType(String accTypeId, AccUser accUser, String description, String closingDay, String accName) {
        this.accTypeId = accTypeId;
        this.accUser = accUser;
        this.description = description;
        this.closingDay = closingDay;
        this.accName = accName;
        items = new ArrayList<>();
        balances = new ArrayList<>();
    }

    public AccountType() {
        items = new ArrayList<>();
        balances = new ArrayList<>();
    }

    public String getAccTypeId() {
        return accTypeId;
    }

    public void setAccTypeId(String accTypeId) {
        this.accTypeId = accTypeId;
    }

    public AccUser getAccUser() {
        return accUser;
    }

    public void setAccUser(AccUser accUser) {
        this.accUser = accUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClosingDay() {
        return closingDay;
    }

    public void setClosingDay(String closingDay) {
        this.closingDay = closingDay;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Balance> getBalances() {
        return balances;
    }

    public void setBalances(List<Balance> balances) {
        this.balances = balances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountType that = (AccountType) o;

        if (!accTypeId.equals(that.accTypeId)) return false;
        if (!accUser.equals(that.accUser)) return false;
        if (!description.equals(that.description)) return false;
        if (!closingDay.equals(that.closingDay)) return false;
        if (!accName.equals(that.accName)) return false;
        if (!items.equals(that.items)) return false;
        return balances.equals(that.balances);

    }

    @Override
    public int hashCode() {
        int result = accTypeId.hashCode();
        result = 31 * result + accUser.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + closingDay.hashCode();
        result = 31 * result + accName.hashCode();
        result = 31 * result + items.hashCode();
        result = 31 * result + balances.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accTypeId='" + accTypeId + '\'' +
                ", description='" + description + '\'' +
                ", closingDay='" + closingDay + '\'' +
                ", accName='" + accName + '\'' +
                ", items=" + items +
                ", balances=" + balances +
                '}';
    }
}
