package com.lushnikova.jpa.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class SliceDTO<T> {
    private List<T> content;
    private int pageSize;
    private SortDTO sort;
    private boolean hasNext;
    private boolean hasPrevious;


    public SliceDTO(Slice<T> slice, Pageable pageable) {
        this.content = slice.getContent();
        this.pageSize = slice.getSize();
        this.sort = new SortDTO(pageable.getSort());
        this.hasNext = slice.hasNext();
        this.hasPrevious = slice.hasPrevious();
    }
}