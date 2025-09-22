package com.woniu.outlet.po;

public class RolePo {
    private Integer id;

    private String rName;

    private Integer rDpid;

    private String rStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }

    public Integer getrDpid() {
        return rDpid;
    }

    public void setrDpid(Integer rDpid) {
        this.rDpid = rDpid;
    }

    public String getrStatus() {
        return rStatus;
    }

    public void setrStatus(String rStatus) {
        this.rStatus = rStatus == null ? null : rStatus.trim();
    }
}