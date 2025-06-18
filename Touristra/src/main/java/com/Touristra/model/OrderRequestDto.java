package com.Touristra.model;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDto {
    private Integer userId;
    private List<OrderItemDto> items;
}