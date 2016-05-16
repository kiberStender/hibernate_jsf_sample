package com.kiber.hibernate.jsf.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sirkleber on 14/05/16.
 */
@Entity
@Table(name = "item")
public class Item implements Serializable, GenericEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column
    private String itemId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "transactiontypeid")
    private TransactionType transactionType;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "acctypeid")
    private AccountType acctype;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "accuserid")
    private AccUser accUser;

    @Column
    private String description;

    @Column
    private Double itemValue;

    @Temporal(value = TemporalType.DATE)
    @Column
    private Date purchaseDate;

    public Item(String itemId, TransactionType transactionType, AccountType acctype, AccUser accUser, String description, Double itemValue, Date purchaseDate) {
        this.itemId = itemId;
        this.transactionType = transactionType;
        this.acctype = acctype;
        this.accUser = accUser;
        this.description = description;
        this.itemValue = itemValue;
        this.purchaseDate = purchaseDate;
    }

    public Item() { }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public AccountType getAcctype() {
        return acctype;
    }

    public void setAcctype(AccountType acctype) {
        this.acctype = acctype;
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

    public Double getItemValue() {
        return itemValue;
    }

    public void setItemValue(Double itemValue) {
        this.itemValue = itemValue;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (!itemId.equals(item.itemId)) return false;
        if (!transactionType.equals(item.transactionType)) return false;
        if (!acctype.equals(item.acctype)) return false;
        if (!accUser.equals(item.accUser)) return false;
        if (description != null ? !description.equals(item.description) : item.description != null) return false;
        if (!itemValue.equals(item.itemValue)) return false;
        return purchaseDate.equals(item.purchaseDate);

    }

    @Override
    public int hashCode() {
        int result = itemId.hashCode();
        result = 31 * result + transactionType.hashCode();
        result = 31 * result + acctype.hashCode();
        result = 31 * result + accUser.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + itemValue.hashCode();
        result = 31 * result + purchaseDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId='" + itemId + '\'' +
                ", transactionType=" + transactionType +
                ", description='" + description + '\'' +
                ", itemValue=" + itemValue +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
