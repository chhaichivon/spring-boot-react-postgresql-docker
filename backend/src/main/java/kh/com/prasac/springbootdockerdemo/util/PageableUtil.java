package kh.com.prasac.springbootdockerdemo.util;

import kh.com.prasac.springbootdockerdemo.exception.BadRequestException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Copyright (c) PRASAC MFI, Ltd. All rights reserved. (https://www.prasac.com.kh/)
 * Author	: Chhai Chivon (chivon.chhai@prasac.com.kh) on 18/02/2021 13:18.
 * Position : Senior Application Development Officer
 */
public class PageableUtil {

    public static Pageable getPageable(Integer page, Integer size,Sort sort){
        if (page < 1)
            throw new BadRequestException("Page request invalid");
        if (size < 1)
            throw new BadRequestException("Size request invalid");
        if (page == 1)
            page = 0;
        else
            page = page - 1;
        return PageRequest.of(page, size, sort);
    }
}
