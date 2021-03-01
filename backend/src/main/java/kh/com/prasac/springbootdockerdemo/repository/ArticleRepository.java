package kh.com.prasac.springbootdockerdemo.repository;

import kh.com.prasac.springbootdockerdemo.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Copyright (c) PRASAC MFI, Ltd. All rights reserved. (https://www.prasac.com.kh/)
 * Author	: Chhai Chivon (chivon.chhai@prasac.com.kh) on 17/02/2021 15:15.
 * Position : Senior Application Development Officer
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer> {

    @Query("SELECT a FROM Article a WHERE a.title LIKE :query OR a.body LIKE :query")
    Page<Article> findAllWithPagination(@Param("query") String query, Pageable pageable);
}
