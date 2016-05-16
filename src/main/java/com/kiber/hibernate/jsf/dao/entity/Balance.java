package com.kiber.hibernate.jsf.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sirkleber on 14/05/16.
 */
@Entity
public class Balance implements Serializable, GenericEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column
    private String balanceId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "acctypeid")
    private AccountType accountType;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "accuserid")
    private AccUser accUser;

    @Column
    private Double calcBalance;

    @Column
    private Double realBalance;

    @Temporal(TemporalType.DATE)
    @Column
    private Date balanceDate;

    public Balance(String balanceId, AccountType accountType, AccUser accUser, Double calcBalance, Double realBalance, Date balanceDate) {
        this.balanceId = balanceId;
        this.accountType = accountType;
        this.accUser = accUser;
        this.calcBalance = calcBalance;
        this.realBalance = realBalance;
        this.balanceDate = balanceDate;
    }

    public Balance() { }

    public String getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(String balanceId) {
        this.balanceId = balanceId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public AccUser getAccUser() {
        return accUser;
    }

    public void setAccUser(AccUser accUser) {
        this.accUser = accUser;
    }

    public Double getCalcBalance() {
        return calcBalance;
    }

    public void setCalcBalance(Double calcBalance) {
        this.calcBalance = calcBalance;
    }

    public Double getRealBalance() {
        return realBalance;
    }

    public void setRealBalance(Double realBalance) {
        this.realBalance = realBalance;
    }

    public Date getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(Date balanceDate) {
        this.balanceDate = balanceDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Balance balance = (Balance) o;

        if (!balanceId.equals(balance.balanceId)) return false;
        if (!accountType.equals(balance.accountType)) return false;
        if (!accUser.equals(balance.accUser)) return false;
        if (!calcBalance.equals(balance.calcBalance)) return false;
        if (!realBalance.equals(balance.realBalance)) return false;
        return balanceDate.equals(balance.balanceDate);

    }

    @Override
    public int hashCode() {
        int result = balanceId.hashCode();
        result = 31 * result + accountType.hashCode();
        result = 31 * result + accUser.hashCode();
        result = 31 * result + calcBalance.hashCode();
        result = 31 * result + realBalance.hashCode();
        result = 31 * result + balanceDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "balanceId='" + balanceId + '\'' +
                ", calcBalance=" + calcBalance +
                ", realBalance=" + realBalance +
                ", balanceDate=" + balanceDate +
                '}';
    }
}
