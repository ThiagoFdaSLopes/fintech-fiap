package br.com.devthiagolopes.model;

import java.sql.Date;

public class Goal {
    private int gls_in_code;
    private int usu_in_code;
    private int gsc_in_code;
    private String gls_st_description;
    private Date gls_dt_init;
    private Date gls_dt_conclusion;
    private float gls_de_amount;
    private float gls_de_progress;
    private Date createdAt;
    private Date updatedAt;

    public Goal(int usu_in_code, int gsc_in_code, String gls_st_description, Date gls_dt_init, Date gls_dt_conclusion, float gls_de_amount, float gls_de_progress) {
        this.usu_in_code = usu_in_code;
        this.gsc_in_code = gsc_in_code;
        this.gls_st_description = gls_st_description;
        this.gls_dt_init = gls_dt_init;
        this.gls_dt_conclusion = gls_dt_conclusion;
        this.gls_de_amount = gls_de_amount;
        this.gls_de_progress = gls_de_progress;
    }

    public Goal(int gls_in_code, int usu_in_code, int gsc_in_code, String gls_st_description, Date gls_dt_init, Date gls_dt_conclusion, float gls_de_amount, float gls_de_progress, Date createdAt, Date updatedAt) {
        this.gls_in_code = gls_in_code;
        this.usu_in_code = usu_in_code;
        this.gsc_in_code = gsc_in_code;
        this.gls_st_description = gls_st_description;
        this.gls_dt_init = gls_dt_init;
        this.gls_dt_conclusion = gls_dt_conclusion;
        this.gls_de_amount = gls_de_amount;
        this.gls_de_progress = gls_de_progress;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getGls_in_code() {
        return gls_in_code;
    }

    public int getUsu_in_code() {
        return usu_in_code;
    }

    public int setUsu_in_code(int usu_in_code) {
        return this.usu_in_code = usu_in_code;
    }

    public int getGsc_in_code() {
        return gsc_in_code;
    }

    public void setGsc_in_code(int gsc_in_code) {
        this.gsc_in_code = gsc_in_code;
    }

    public String getgls_st_description() {
        return gls_st_description;
    }

    public void setgls_st_description(String gls_st_description) {
        this.gls_st_description = gls_st_description;
    }

    public Date getGls_dt_init() {
        return gls_dt_init;
    }

    public void setGls_dt_init(Date gls_dt_init) {
        this.gls_dt_init = gls_dt_init;
    }

    public Date getGls_dt_conclusion() {
        return gls_dt_conclusion;
    }

    public void setGls_dt_conclusion(Date gls_dt_conclusion) {
        this.gls_dt_conclusion = gls_dt_conclusion;
    }

    public float getGls_de_amount() {
        return gls_de_amount;
    }

    public void setGls_de_amount(float gls_de_amount) {
        this.gls_de_amount = gls_de_amount;
    }

    public float getGls_de_progress() {
        return gls_de_progress;
    }

    public void setGls_de_progress(float gls_de_progress) {
        this.gls_de_progress = gls_de_progress;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
