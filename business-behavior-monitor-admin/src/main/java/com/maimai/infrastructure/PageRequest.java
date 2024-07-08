package com.maimai.infrastructure;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * @author maimai
 * @description
 * @create 2024/7/8
 */
public class PageRequest implements Pageable {
    private int pageNumber;
    private int pageSize;
    private Sort sort;

    public PageRequest() {
    }

    public PageRequest(int pageSize, int pageNumber) {
        this(pageSize, pageNumber, Sort.unsorted());
    }

    public PageRequest(int pageNumber, int pageSize, Sort sort) {
        if (pageNumber < 0) throw new IllegalArgumentException("Page number cannot be negative");
        if (pageSize < 1) throw new IllegalArgumentException("Page size cannot be negative");

        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.sort = sort;
    }

    @Override
    public int getPageNumber() {
        return this.pageNumber;
    }

    @Override
    public int getPageSize() {
        return this.pageSize;
    }

    @Override
    public long getOffset() {
        return (long)this.pageNumber * (long)this.pageSize;
    }

    @Override
    public Sort getSort() {
        return this.sort;
    }

    @Override
    public Pageable next() {
        return new PageRequest(this.getPageNumber() + 1, this.getPageSize(), this.getSort());
    }

    @Override
    public Pageable previousOrFirst() {
        return this.pageNumber == 0? this : new PageRequest(this.getPageNumber() - 1, this.getPageSize(), this.getSort());
    }

    @Override
    public Pageable first() {
        return new PageRequest(0, this.getPageSize(), this.getSort());
    }

    @Override
    public Pageable withPage(int pageNumber) {
        return new PageRequest(pageNumber, this.pageSize, this.sort);
    }

    @Override
    public boolean hasPrevious() {
        return this.pageNumber > 0;
    }

    public static PageRequest of(int pageNumber, int pageSize) {
        return new PageRequest(pageNumber, pageSize);
    }

    public static PageRequest of(int pageNumber, int pageSize, Sort sort) {
        return new PageRequest(pageNumber, pageSize, sort);
    }
}
