package com.ecommerce.pojo.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {
    private Long id;
    private Double quantity;
    private Double perItemPrice;
    private Double itemWeight;
    private Double itemDiscountPercentage;
}
