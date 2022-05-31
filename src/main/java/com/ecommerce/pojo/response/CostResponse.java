package com.ecommerce.pojo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CostResponse extends CommonResponse{
    private Double cost;
    public CostResponse(Boolean status,String message,Double cost){
        super(status,message);
        this.cost=cost;
    }
    public CostResponse(Boolean status,String message){super(status,message);}
    public static CostResponse success(Double cost){
        return new CostResponse(true,"SUCCESS",cost);
    }
    public static CostResponse failed(String message){
        return new CostResponse(false,message);
    }
}
