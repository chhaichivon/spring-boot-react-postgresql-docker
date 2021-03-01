package kh.com.prasac.springbootdockerdemo.model;

/**
 * Copyright (c) PRASAC MFI, Ltd. All rights reserved. (https://www.prasac.com.kh/)
 * Author	: Chhai Chivon (chivon.chhai@prasac.com.kh) on 7/28/20 7:46 am.
 * Position : Senior Application Development Officer
 */
public enum EStatus {

    ACTIVE("ACTIVE","Active","Active's status"),
    INACTIVE("INACTIVE","Inactive","Inactive's status"),
    DELETE("DELETE","Delete","Delete's status"),
    DISABLE("DISABLE","Disable","Disable's status"),
    ;

    private String code;
    private String name;
    private String description;

    EStatus(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
