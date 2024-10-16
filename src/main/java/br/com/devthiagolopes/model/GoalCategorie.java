package br.com.devthiagolopes.model;

import java.sql.Date;

public class GoalCategorie {
    private int gsc_in_code;
    private String gsc_st_type;
    private Date createdAt;
    private Date updatedAt;

    public GoalCategorie(String gsc_st_type) {
        this.gsc_st_type = gsc_st_type;
    }

    public GoalCategorie(int gsc_in_code, String gsc_st_type, Date createdAt, Date updatedAt) {
        this.gsc_in_code = gsc_in_code;
        this.gsc_st_type = gsc_st_type;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getGsc_in_code() {
        return gsc_in_code;
    }

    public String getGsc_st_type() {
        return gsc_st_type;
    }

    public void setGsc_st_type(String gsc_st_type) {
        this.gsc_st_type = gsc_st_type;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
