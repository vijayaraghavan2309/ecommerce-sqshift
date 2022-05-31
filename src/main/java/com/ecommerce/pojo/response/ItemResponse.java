package com.ecommerce.pojo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponse extends CommonResponse {
    private Long id;
    public ItemResponse(Boolean status, String message, Long id){
        super(status,message);
        this.id=id;
    }
    public ItemResponse(Boolean status, String message){
        super(status,message);
    }
    public static ItemResponse success(Long id){
        return new ItemResponse(true,"Cart saved successfully",id);
    }
    public static ItemResponse failed(String message){
        return new ItemResponse(false, message);
    }
}
