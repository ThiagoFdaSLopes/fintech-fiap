package br.com.devthiagolopes.model;

import java.sql.Date;

public class TransactionType {
    private int tnt_in_code;
    private String tnt_st_type;
    private Date createdAt;
    private Date updatedAt;

    public TransactionType(String tnt_st_type) {
        this.tnt_st_type = tnt_st_type;
    }

    public TransactionType(int tnt_in_code, String tnt_st_type, Date createdAt, Date updatedAt) {
        this.tnt_in_code = tnt_in_code;
        this.tnt_st_type = tnt_st_type;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public String getTnt_st_type() {
        return tnt_st_type;
    }

    public void setTnt_st_type(String tnt_st_type) {
        this.tnt_st_type = tnt_st_type;
    }

    public int getTnt_in_code() {
        return tnt_in_code;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
