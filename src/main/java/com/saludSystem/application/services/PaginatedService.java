package com.saludSystem.application.services;

import java.util.List;
import java.util.UUID;

public interface PaginatedService {
    long getTotalCount();
    //<T> List<T> getPagedResults(UUID hospitalId, int page, int rows);
}