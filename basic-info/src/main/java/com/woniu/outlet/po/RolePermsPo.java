package com.woniu.outlet.po;

public class RolePermsPo {
    private Integer id;

    private String rpName;

    private String rpCode;

    private Integer rpParentid;

    private String rpType;

    private String rpStatus;

    private String rpPercode;

    private String rpIcon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRpName() {
        return rpName;
    }

    public void setRpName(String rpName) {
        this.rpName = rpName == null ? null : rpName.trim();
    }

    public String getRpCode() {
        return rpCode;
    }

    public void setRpCode(String rpCode) {
        this.rpCode = rpCode == null ? null : rpCode.trim();
    }

    public Integer getRpParentid() {
        return rpParentid;
    }

    public void setRpParentid(Integer rpParentid) {
        this.rpParentid = rpParentid;
    }

    public String getRpType() {
        return rpType;
    }

    public void setRpType(String rpType) {
        this.rpType = rpType == null ? null : rpType.trim();
    }

    public String getRpStatus() {
        return rpStatus;
    }

    public void setRpStatus(String rpStatus) {
        this.rpStatus = rpStatus == null ? null : rpStatus.trim();
    }

    public String getRpPercode() {
        return rpPercode;
    }

    public void setRpPercode(String rpPercode) {
        this.rpPercode = rpPercode == null ? null : rpPercode.trim();
    }

    public String getRpIcon() {
        return rpIcon;
    }

    public void setRpIcon(String rpIcon) {
        this.rpIcon = rpIcon == null ? null : rpIcon.trim();
    }
}