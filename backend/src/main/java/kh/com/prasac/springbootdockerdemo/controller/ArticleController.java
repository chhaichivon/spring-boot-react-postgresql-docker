package kh.com.prasac.springbootdockerdemo.controller;

import kh.com.prasac.springbootdockerdemo.exception.BadRequestException;
import kh.com.prasac.springbootdockerdemo.model.Article;
import kh.com.prasac.springbootdockerdemo.model.EStatus;
import kh.com.prasac.springbootdockerdemo.payload.ApiObjectResponse;
import kh.com.prasac.springbootdockerdemo.payload.ApiPageResponse;
import kh.com.prasac.springbootdockerdemo.payload.Pagination;
import kh.com.prasac.springbootdockerdemo.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Copyright (c) PRASAC MFI, Ltd. All rights reserved. (https://www.prasac.com.kh/)
 * Author	: Chhai Chivon (chivon.chhai@prasac.com.kh) on 17/02/2021 15:06.
 * Position : Senior Application Development Officer
 */
@RestController
@RequestMapping(value = "/api/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("")
    public ResponseEntity<ApiPageResponse<Article>> finAllWithPagination(@RequestParam(value = "query", defaultValue = "", required = false) String query,
                                                                         @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                         @RequestParam(value = "size", defaultValue = "10") Integer size) {
        ApiPageResponse apiPageResponse = new ApiPageResponse();
        try {
            Map<String,Object> map = articleService.finAllWithPagination(query,page,size);
            List<Article> articles = (List<Article>) map.get("data");
            Pagination pagination = (Pagination) map.get("pagination");
            apiPageResponse.setCode(HttpStatus.OK.value());
            apiPageResponse.setMessage(HttpStatus.OK.getReasonPhrase());
            apiPageResponse.setStatus(true);
            apiPageResponse.setData(articles);
            apiPageResponse.setPagination(pagination);
        }catch (BadRequestException e){
            apiPageResponse.setCode(HttpStatus.BAD_REQUEST.value());
            apiPageResponse.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
            apiPageResponse.setStatus(false);
            return new ResponseEntity<>(apiPageResponse, HttpStatus.BAD_REQUEST);
        }catch (NoSuchElementException e) {
            apiPageResponse.setCode(HttpStatus.NOT_FOUND.value());
            apiPageResponse.setMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
            apiPageResponse.setStatus(false);
            return new ResponseEntity<>(apiPageResponse, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(apiPageResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiObjectResponse<Article>> get(@PathVariable Integer id) {
        ApiObjectResponse apiObjectResponse = new ApiObjectResponse();
        try {
            Article article = articleService.get(id);
            apiObjectResponse.setCode(HttpStatus.OK.value());
            apiObjectResponse.setMessage(HttpStatus.OK.getReasonPhrase());
            apiObjectResponse.setStatus(true);
            apiObjectResponse.setData(article);
        } catch (NoSuchElementException e) {
            apiObjectResponse.setCode(HttpStatus.NOT_FOUND.value());
            apiObjectResponse.setMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
            apiObjectResponse.setStatus(false);
            return new ResponseEntity<>(apiObjectResponse, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(apiObjectResponse, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ApiObjectResponse<Article>> add(@RequestBody Article article) {
        ApiObjectResponse apiObjectResponse = new ApiObjectResponse();
        try {
            apiObjectResponse.setCode(HttpStatus.CREATED.value());
            apiObjectResponse.setMessage(HttpStatus.CREATED.getReasonPhrase());
            apiObjectResponse.setStatus(true);
            article.setCreatedAt(new Date());
            article.setCreatedBy("Chhai Chivon");
            article.setStatus(EStatus.ACTIVE);
            apiObjectResponse.setData(articleService.save(article));
        } catch (NoSuchElementException e) {
            apiObjectResponse.setCode(HttpStatus.BAD_REQUEST.value());
            apiObjectResponse.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
            apiObjectResponse.setStatus(false);
            return new ResponseEntity<>(apiObjectResponse, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(apiObjectResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiObjectResponse<Article>> update(@RequestBody Article article, @PathVariable Integer id) {
        ApiObjectResponse apiObjectResponse = new ApiObjectResponse();
        try {
            Article existProduct = articleService.get(id);
            if(Objects.nonNull(existProduct)){
                existProduct.setUpdatedAt(new Date());
                existProduct.setUpdatedBy("Chhai Chivon");
                existProduct.setStatus(EStatus.ACTIVE);
                existProduct.setTitle(article.getTitle());
                existProduct.setBody(article.getBody());
                existProduct = articleService.save(existProduct);
                apiObjectResponse.setCode(HttpStatus.OK.value());
                apiObjectResponse.setMessage(HttpStatus.OK.getReasonPhrase());
                apiObjectResponse.setStatus(true);
                apiObjectResponse.setData(existProduct);
            }else{
                apiObjectResponse.setCode(HttpStatus.NOT_FOUND.value());
                apiObjectResponse.setMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
                apiObjectResponse.setStatus(false);
                return new ResponseEntity<>(apiObjectResponse, HttpStatus.NOT_FOUND);
            }
        } catch (NoSuchElementException e) {
            apiObjectResponse.setCode(HttpStatus.NOT_FOUND.value());
            apiObjectResponse.setMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
            apiObjectResponse.setStatus(false);
            return new ResponseEntity<>(apiObjectResponse, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(apiObjectResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiObjectResponse<Article>> delete(@PathVariable Integer id) {
        ApiObjectResponse apiObjectResponse = new ApiObjectResponse();
        try {
            Article existProduct = articleService.get(id);
            if(Objects.nonNull(existProduct)){
                articleService.delete(id);
                apiObjectResponse.setCode(HttpStatus.OK.value());
                apiObjectResponse.setMessage(HttpStatus.OK.getReasonPhrase());
                apiObjectResponse.setStatus(true);
                apiObjectResponse.setData(existProduct);
            }else{
                apiObjectResponse.setCode(HttpStatus.NOT_FOUND.value());
                apiObjectResponse.setMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
                apiObjectResponse.setStatus(false);
                return new ResponseEntity<>(apiObjectResponse, HttpStatus.NOT_FOUND);
            }
        } catch (NoSuchElementException e) {
            apiObjectResponse.setCode(HttpStatus.NOT_FOUND.value());
            apiObjectResponse.setMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
            apiObjectResponse.setStatus(false);
            return new ResponseEntity<>(apiObjectResponse, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(apiObjectResponse, HttpStatus.OK);
    }
}
