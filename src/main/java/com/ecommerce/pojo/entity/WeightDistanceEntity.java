package com.ecommerce.pojo.entity;

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
@Table(name="weight_distance")
public class WeightDistanceEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="price_id")
    private Long priceId;

    @Column(name="distance_min")
    private Double minDistance;

    @Column(name="distance_max")
    private Double maxDistance;

    @Column(name="weight_min")
    private Double minWeight;

    @Column(name="weight_max")
    private Double maxWeight;

    @Column(name="relative_price")
    private Double relativePrice;
}
