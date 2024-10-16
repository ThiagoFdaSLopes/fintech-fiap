package br.com.devthiagolopes.model;

import java.sql.Date;

public class Investiment {
    private int inv_in_code;
    private int ivt_in_code;
    private int usu_in_code;
    private String inv_st_name;
    private float inv_de_amount;
    private Date inv_dt_buy;
    private Date createdAt;
    private Date updatedAt;

    public Investiment(int ivt_in_code, int usu_in_code, String inv_st_name, float inv_de_amount, Date inv_dt_buy) {
        this.ivt_in_code = ivt_in_code;
        this.usu_in_code = usu_in_code;
        this.inv_st_name = inv_st_name;
        this.inv_de_amount = inv_de_amount;
        this.inv_dt_buy = inv_dt_buy;
    }

    public Investiment(int inv_in_code, int ivt_in_code, int usu_in_code, String inv_st_name, float inv_de_amount, Date inv_dt_buy, Date createdAt, Date updatedAt) {
        this.inv_in_code = inv_in_code;
        this.ivt_in_code = ivt_in_code;
        this.usu_in_code = usu_in_code;
        this.inv_st_name = inv_st_name;
        this.inv_de_amount = inv_de_amount;
        this.inv_dt_buy = inv_dt_buy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public int getInv_in_code() {
        return inv_in_code;
    }

    public int getIvt_in_code() {
        return ivt_in_code;
    }

    public void setIvt_in_code(int ivt_in_code) {
        this.ivt_in_code = ivt_in_code;
    }

    public int getUsu_in_code() {
        return usu_in_code;
    }

    public void setUsu_in_code(int usu_in_code) {
        this.usu_in_code = usu_in_code;
    }

    public String getInv_st_name() {
        return inv_st_name;
    }

    public void setInv_st_name(String inv_st_name) {
        this.inv_st_name = inv_st_name;
    }

    public float getInv_de_amount() {
        return inv_de_amount;
    }

    public void setInv_de_amount(float inv_de_amount) {
        this.inv_de_amount = inv_de_amount;
    }

    public Date getInv_dt_buy() {
        return inv_dt_buy;
    }

    public void setInv_dt_buy(Date inv_dt_buy) {
        this.inv_dt_buy = inv_dt_buy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
