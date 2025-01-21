package com.saludSystem.util;

import java.util.List;

public class PageResult<T> {
    private List<T> data;
    private long totalData;

    public PageResult(List<T> data, long totalData) {
        this.data = data;
        this.totalData = totalData;
    }

}
