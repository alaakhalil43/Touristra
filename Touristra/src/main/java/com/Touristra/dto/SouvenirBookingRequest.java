package com.Touristra.dto;

import lombok.Data;

@Data
public class SouvenirBookingRequest {
    private Integer orderId;
    private Integer souvenirId;
    private Integer quantity;
    private Double price;
}

