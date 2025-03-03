package com.saludSystem.aplicacion.services;

public interface PaginatedService {
    long getTotalCount();
    //<T> List<T> getPagedResults(UUID hospitalId, int page, int rows);
}