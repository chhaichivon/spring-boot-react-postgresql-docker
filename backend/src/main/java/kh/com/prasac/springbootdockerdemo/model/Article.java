package kh.com.prasac.springbootdockerdemo.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Copyright (c) PRASAC MFI, Ltd. All rights reserved. (https://www.prasac.com.kh/)
 * Author	: Chhai Chivon (chivon.chhai@prasac.com.kh) on 17/02/2021 15:06.
 * Position : Senior Application Development Officer
 */
@Entity
@Table(name = "tb_articles")
public class Article extends AuditEntity {

    private Integer id;
    private String title;
    private String body;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public EStatus getStatus() {
        return super.getStatus();
    }

    @Override
    public void setStatus(EStatus status) {
        super.setStatus(status);
    }

    @Override
    public Date getCreatedAt() {
        return super.getCreatedAt();
    }

    @Override
    public void setCreatedAt(Date createdAt) {
        super.setCreatedAt(createdAt);
    }

    @Override
    public Date getUpdatedAt() {
        return super.getUpdatedAt();
    }

    @Override
    public void setUpdatedAt(Date updatedAt) {
        super.setUpdatedAt(updatedAt);
    }

    @Override
    public String getUpdatedBy() {
        return super.getUpdatedBy();
    }

    @Override
    public void setUpdatedBy(String updatedBy) {
        super.setUpdatedBy(updatedBy);
    }

    @Override
    public String getCreatedBy() {
        return super.getCreatedBy();
    }

    @Override
    public void setCreatedBy(String createdBy) {
        super.setCreatedBy(createdBy);
    }
}
