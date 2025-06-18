package com.Touristra.model;

import lombok.Data;

@Data
public class OrderItemDto {
    private Integer productId;
    private Integer privateTourId;
    private Integer quantity;
}