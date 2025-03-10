package com.saludSystem.Generals.security.util;

public interface PaginatedService {
    long getTotalCount();
    //<T> List<T> getPagedResults(UUID hospitalId, int page, int rows);
}