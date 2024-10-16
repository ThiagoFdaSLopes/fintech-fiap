package br.com.devthiagolopes.model;

import java.sql.Date;

public class InvestimentType {
    private int ivt_in_code;
    private String ivt_st_type;
    private Date createdAt;
    private Date updatedAt;

    public InvestimentType(String ivt_st_type) {
        this.ivt_st_type = ivt_st_type;
    }

    public InvestimentType(int ivt_in_code, String ivt_st_type, Date createdAt, Date updatedAt) {
        this.ivt_in_code = ivt_in_code;
        this.ivt_st_type = ivt_st_type;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public int getIvt_in_code() {
        return ivt_in_code;
    }

    public String getIvt_st_type() {
        return ivt_st_type;
    }

    public void setIvt_st_type(String ivt_st_type) {
        this.ivt_st_type = ivt_st_type;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
