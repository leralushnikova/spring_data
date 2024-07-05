package com.lushnikova.jpa.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public final class PageDTO<T> {
    private List<T> content;    // в листе лежит, тот контент, который я хочу получить
    private int totalPages;     //какое количество страниц
    private long totalElements; //тотальное количество элементов
    private int pageSize;       //
    private int pageNumber;     //
    private SortDTO sort;       //


    public PageDTO(Page<T> page, Pageable pageable) {
        this.content = page.getContent();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.pageSize = page.getSize();
        this.pageNumber = page.getNumber();
        this.sort = new SortDTO(pageable.getSort());
    }

    public PageDTO(List<T> content, int pageNumber, int pageSize, int size) {
        this.content = content;
        this.totalPages = size / pageSize;
        this.totalElements = size;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }
}
