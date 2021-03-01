package kh.com.prasac.springbootdockerdemo.payload;


/**
 * Copyright (c) PRASAC MFI, Ltd. All rights reserved. (https://www.prasac.com.kh/)
 * Author	: Chhai Chivon (chivon.chhai@prasac.com.kh) on 17/02/2021 15:33.
 * Position : Senior Application Development Officer
 */
public class Pagination {

    private Integer page;
    private Integer limit;
    private int totalCount;
    private int totalPages;
    private int offset;

    public Pagination() {
        this(1, 10, 0, 0);
    }

    public Pagination(int page, int limit) {
        this.page = page;
        this.limit = limit;
        this.totalCount = 0;
        this.totalPages = 0;
    }

    public Pagination(int page, int limit, int totalCount) {
        this.page = page;
        this.limit = limit;
        setTotalCount(totalCount);
    }

    public Pagination(int page, int limit, int totalCount, int totalPages) {
        this.page = page;
        this.limit = limit;
        this.totalCount = totalCount;
        this.totalPages = totalPages;
    }

    public int getPage() {
        return this.page;
    }

    public int totalPages() {
        return (int)Math.ceil((double)this.totalCount / (double)this.limit);
    }

    public int nextPage() {
        return this.page + 1;
    }

    public int previousPage() {
        return this.page - 1;
    }

    public boolean hasNextPage() {
        return this.nextPage() <= this.totalPages();
    }

    public boolean hasPreviousPage() {
        return this.previousPage() >= 1;
    }

    public int offset() {
        this.offset = (this.page - 1) * this.limit;
        return this.offset;
    }

    public void setPage(int currentPage) {
        this.page = currentPage;
        this.offset();
    }

    public int getLimit() {
        return this.limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        this.totalPages = this.totalPages();
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getOffset() {
        return this.offset();
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
