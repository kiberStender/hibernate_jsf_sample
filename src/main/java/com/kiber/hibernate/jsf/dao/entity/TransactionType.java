package com.kiber.hibernate.jsf.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sirkleber on 12/05/16.
 */
@Entity
@Table(name = "transactiontype")
public class TransactionType implements Serializable, GenericEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "transactiontypeid")
    private String transactionTypeId;

    @Column(name = "transactiontypename")
    private String transactionTypeName;

    public TransactionType(String transactionTypeId, String transactionTypeName) {
        this.transactionTypeId = transactionTypeId;
        this.transactionTypeName = transactionTypeName;
    }

    public TransactionType() { }

    public String getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(String transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public String getTransactionTypeName() {
        return transactionTypeName;
    }

    public void setTransactionTypeName(String transactionTypeName) {
        this.transactionTypeName = transactionTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionType that = (TransactionType) o;

        if (!transactionTypeId.equals(that.transactionTypeId)) return false;
        return transactionTypeName.equals(that.transactionTypeName);

    }

    @Override
    public int hashCode() {
        int result = transactionTypeId.hashCode();
        result = 31 * result + transactionTypeName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TransactionType{" +
                "transactionTypeId='" + transactionTypeId + '\'' +
                ", transactionTypeName='" + transactionTypeName + '\'' +
                '}';
    }
}
