package com.ecommerce.pojo.entity;

import com.ecommerce.pojo.request.ItemRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="checkout_cart")
public class CheckOutCartEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="cart_id")
    private Long cartId;

    @Column(name="item_id")
    private Long itemId;

    @Column(name="item_quantity")
    private Double itemQuantity;

    @Column(name="item_unit_price")
    private Double unitPrice;

    @Column(name="item_total_price")
    private Double itemTotalPrice;

    @Column(name="item_discount_percentage")
    private Double itemDiscountPercentage;

    @Column(name="item_weight")
    private Double itemWeight;

    public CheckOutCartEntity(ItemRequest item) {
        this.itemId = item.getId();
        this.itemQuantity = item.getQuantity();
        this.unitPrice = item.getPerItemPrice();
        this.itemTotalPrice =(item.getPerItemPrice() * item.getQuantity()) - ((item.getPerItemPrice() * item.getQuantity())*item.getItemDiscountPercentage()/100);
        this.itemWeight=item.getItemWeight();
        this.itemDiscountPercentage=item.getItemDiscountPercentage();
    }
}
