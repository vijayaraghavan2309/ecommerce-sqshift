package com.ecommerce.service;

import com.ecommerce.constants.ServiceConstants;
import com.ecommerce.pojo.entity.CheckOutCartEntity;
import com.ecommerce.pojo.request.CostRequest;
import com.ecommerce.pojo.request.ItemRequest;
import com.ecommerce.pojo.response.*;
import com.ecommerce.repository.CheckOutCartRepo;
import com.ecommerce.repository.WeightDistanceRepo;
import com.ecommerce.util.RequestUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ECommerceService {

    @Autowired
    CheckOutCartRepo checkOutCartRepo;

    @Autowired
    RequestUtil requestUtil;

    @Autowired
    WeightDistanceRepo weightDistanceRepo;

    public ItemResponse addItemsToCart(ItemRequest items){
        try{
            items=getItemDetail(items);
            Long id = checkOutCartRepo.save(new CheckOutCartEntity(items)).getCartId();
            return ItemResponse.success(id);
        }catch(Exception e){
            return ItemResponse.failed("Exception in adding items to cart:"+ e.getMessage());
        }
    }

    public ItemRequest getItemDetail(ItemRequest items) throws Exception {
        String response= requestUtil.getHTML(ServiceConstants.DOMAIN_URL + ServiceConstants.PRODUCT_API + "/"+items.getId());
        HashMap<String, Object> map = new Gson().fromJson(response, HashMap.class);
        Gson gson = new Gson();
        String json = gson.toJson(map.get("product"));
        HashMap<String, Object> productMap = new Gson().fromJson(json, HashMap.class);
        items.setPerItemPrice((Double)productMap.get(ServiceConstants.PRICE_TAG));
        items.setItemDiscountPercentage((Double)productMap.get(ServiceConstants.DISCOUNT_TAG));
        items.setItemWeight((Double)productMap.get(ServiceConstants.WEIGHT_TAG));
        return items;
    }
    public ItemListResponse listAllItems(){
        try{
            List<CheckOutCartEntity> items= checkOutCartRepo.findAll();
            return ItemListResponse.success(items.stream().map(item-> new SingleItemResponse(item.getItemId(),item.getItemQuantity(),item.getUnitPrice(),item.getItemTotalPrice())).collect(Collectors.toList()) );
        }catch(Exception e){
            return ItemListResponse.failed("Item fetch failed: "+e.getMessage());
        }
    }

    public CommonResponse deleteAllItems(){
        try{
            checkOutCartRepo.deleteAll();
            return CommonResponse.success("All items deleted successfully");
        }catch(Exception e){
            return CommonResponse.failed("Item deletion failed:"+ e.getMessage());
        }
    }

    public Double getDeliverCost(Double kms){
        Double totalWeight= checkOutCartRepo.getItemWeight();
        return weightDistanceRepo.getRelativePrice(totalWeight,kms);
    }

    public Double getTotalCost(Double totalItemCost,Double kms){
        return totalItemCost+getDeliverCost(kms);
    }
    public Double getTotalItemCost(){
        return checkOutCartRepo.getTotalCost();
    }

    public CostResponse findTotalCostofCart(CostRequest request) {
        try {
            String response= requestUtil.getHTML(ServiceConstants.DOMAIN_URL + ServiceConstants.DISTANCE_API +"?"+ "postal_code=" + request.getPinCode());
            HashMap<String, Object> map = new Gson().fromJson(response, HashMap.class);
            Double kms=(Double)map.get(ServiceConstants.DISTANCE_TAG);
            return CostResponse.success(getTotalCost(getTotalItemCost(),kms));
        }catch(Exception e){
            return CostResponse.failed("Total cost calculation failed:"+ e.getMessage());
        }
    }

}
