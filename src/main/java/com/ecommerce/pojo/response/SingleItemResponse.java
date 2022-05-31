package com.ecommerce.pojo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SingleItemResponse {
    private Long itemId;
    private Double quantity;
    private Double unitPrice;
    private Double totalPrice;
}
