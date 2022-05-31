package com.ecommerce.repository;

import com.ecommerce.pojo.entity.CheckOutCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckOutCartRepo extends JpaRepository<CheckOutCartEntity,Long> {
    @Query(value="select sum(item_total_price) total_price from checkout_cart ",nativeQuery = true)
    Double getTotalCost();
    @Query(value="select sum(item_weight) from checkout_cart",nativeQuery=true)
    Double getItemWeight();
}
