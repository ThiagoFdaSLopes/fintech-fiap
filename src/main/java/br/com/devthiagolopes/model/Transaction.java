package br.com.devthiagolopes.model;

import java.sql.Date;

public class Transaction {
    private int trn_in_code;
    private int tnt_in_code;
    private int usu_in_code;
    private float trn_de_amount;
    private String trn_st_description;
    private Date createdAt;
    private Date updatedAt;

    public Transaction(int tnt_in_code, int usu_in_code, float trn_de_amount, String trn_st_description) {
        this.tnt_in_code = tnt_in_code;
        this.usu_in_code = usu_in_code;
        this.trn_de_amount = trn_de_amount;
        this.trn_st_description = trn_st_description;
    }

    public Transaction(int trn_in_code, int tnt_in_code, int usu_in_code, float trn_de_amount, String trn_st_description, Date createdAt, Date updatedAt) {
        this.trn_in_code = trn_in_code;
        this.tnt_in_code = tnt_in_code;
        this.usu_in_code = usu_in_code;
        this.trn_de_amount = trn_de_amount;
        this.trn_st_description = trn_st_description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getTrn_in_code() {
        return trn_in_code;
    }

    public void setTrn_in_code(int trn_in_code) {
        this.trn_in_code = trn_in_code;
    }

    public int getTnt_in_code() {
        return tnt_in_code;
    }

    public void setTnt_in_code(int tnt_in_code) {
        this.tnt_in_code = tnt_in_code;
    }

    public int getUsu_in_code() {
        return usu_in_code;
    }

    public void setUsu_in_code(int usu_in_code) {
        this.usu_in_code = usu_in_code;
    }

    public float getTrn_de_amount() {
        return trn_de_amount;
    }

    public void setTrn_de_amount(float trn_de_amount) {
        this.trn_de_amount = trn_de_amount;
    }

    public String getTrn_st_description() {
        return trn_st_description;
    }

    public void setTrn_st_description(String trn_st_description) {
        this.trn_st_description = trn_st_description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public java.sql.Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Transaction {" +
                "Transaction ID = " + trn_in_code +
                ", Type ID = " + tnt_in_code +
                ", User ID = " + usu_in_code +
                ", Amount = " + trn_de_amount +
                ", Description = '" + trn_st_description + '\'' +
                ", Created At = " + createdAt +
                ", Updated At = " + updatedAt +
                '}';
    }
}
