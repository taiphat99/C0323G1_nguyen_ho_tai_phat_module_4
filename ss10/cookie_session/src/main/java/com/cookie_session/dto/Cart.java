package com.cookie_session.dto;


import com.cookie_session.model.Product;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> productMap = new HashMap<>();

    public Cart() {
    }

    public Map<Product, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Product, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(Product product) {
        if (productMap.containsKey(product)) {
            Integer currentValue = productMap.get(product);
            productMap.replace(product, currentValue + 1);
        } else {
            productMap.put(product, 1);
        }
    }
}
