package com.ecommerce.pojo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemListResponse extends CommonResponse {
    List<SingleItemResponse> items;
    public ItemListResponse (Boolean status, String message, List<SingleItemResponse> items) {
        super(status, message);
        this.items= items;
    }
    public ItemListResponse(Boolean status,String message){
        super(status, message);
    }
    public static ItemListResponse success(List<SingleItemResponse> items){
        return new ItemListResponse(true, "Success", items);
    }
    public static ItemListResponse failed(String message){
        return new ItemListResponse(false,message);
    }
}
