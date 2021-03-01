package kh.com.prasac.springbootdockerdemo.service;

import kh.com.prasac.springbootdockerdemo.model.Article;
import kh.com.prasac.springbootdockerdemo.repository.ArticleRepository;
import kh.com.prasac.springbootdockerdemo.payload.Pagination;
import kh.com.prasac.springbootdockerdemo.util.PageableUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (c) PRASAC MFI, Ltd. All rights reserved. (https://www.prasac.com.kh/)
 * Author	: Chhai Chivon (chivon.chhai@prasac.com.kh) on 17/02/2021 15:15.
 * Position : Senior Application Development Officer
 */
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Map<String,Object> finAllWithPagination(String query, int page, int size) {
        Pageable pageable = PageableUtil.getPageable(page, size, Sort.by("id").ascending());
        Page<Article> articlePage = null;
        if(query.isEmpty())
            articlePage = articleRepository.findAll(pageable);
        else
            articlePage = articleRepository.findAllWithPagination(query,pageable);
        List<Article> articles = articlePage.getContent();
        Pagination pagination = new Pagination(page == 0 ? 1 : page , size,size,articlePage.getTotalPages());
        Map<String,Object> map = new HashMap<>();
        map.put("data",articles);
        map.put("pagination",pagination);
        return map;
    }

    public Article save(Article article) {
        return articleRepository.save(article);
    }

    public Article get(Integer id) {
        return articleRepository.findById(id).get();
    }

    public void delete(Integer id) {
        articleRepository.deleteById(id);
    }
}
