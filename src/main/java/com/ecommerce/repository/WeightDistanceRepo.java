package com.ecommerce.repository;

import com.ecommerce.pojo.entity.WeightDistanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightDistanceRepo extends JpaRepository<WeightDistanceEntity,Long> {
    @Query(value="select relative_price from weight_distance where ? between weight_min and weight_max and ? between distance_min and distance_max",nativeQuery = true)
    Double getRelativePrice(Double weight,Double kms);
}
