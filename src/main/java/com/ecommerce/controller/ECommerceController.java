package com.ecommerce.controller;

import com.ecommerce.pojo.request.CostRequest;
import com.ecommerce.pojo.request.ItemRequest;
import com.ecommerce.pojo.response.CommonResponse;
import com.ecommerce.pojo.response.CostResponse;
import com.ecommerce.pojo.response.ItemListResponse;
import com.ecommerce.pojo.response.ItemResponse;
import com.ecommerce.service.ECommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ecommerce")
public class ECommerceController {
    @Autowired
    ECommerceService eCommerceService;

    @PostMapping("/add")
    public ResponseEntity<ItemResponse> addItemstoCart(@RequestBody ItemRequest items){
        ItemResponse response = eCommerceService.addItemsToCart(items);
        return response.isStatus()?ResponseEntity.ok(response):ResponseEntity.badRequest().body(response);
    }
    
    @GetMapping("/get")
    public ResponseEntity<ItemListResponse> listAllItems(){
        ItemListResponse response = eCommerceService.listAllItems();
        return response.isStatus()?ResponseEntity.ok(response):ResponseEntity.badRequest().body(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<CommonResponse> deleteAllItems(){
        CommonResponse response = eCommerceService.deleteAllItems();
        return response.isStatus()?ResponseEntity.ok(response):ResponseEntity.badRequest().body(response);
    }

    @GetMapping("/totalCost")
    public ResponseEntity<CostResponse> getTotalCost(@RequestBody CostRequest costRequest){
        CostResponse response = eCommerceService.findTotalCostofCart(costRequest);
        return response.isStatus()?ResponseEntity.ok(response):ResponseEntity.badRequest().body(response);
    }
}
