package com.saludSystem.dtos.Generals;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PaginatedResponse<T> {
    private List<T> data;
    private Long totalData;
}
