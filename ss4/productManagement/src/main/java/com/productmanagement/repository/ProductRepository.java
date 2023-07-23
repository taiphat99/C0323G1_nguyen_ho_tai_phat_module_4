package com.productmanagement.repository;

import com.productmanagement.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static final Map<Integer, Product> PRODUCTS = new HashMap<>();

    static {
        PRODUCTS.put(1,new Product(1,"Iphone 14 Pro Max", 3000, 50, "Apple", "Smooth", true));
        PRODUCTS.put(2,new Product(2,"Iphone 14 Pro", 2600, 20, "Apple", "Smooth", true));
        PRODUCTS.put(3,new Product(3,"Samsung Galaxy S23 Ultra", 1900, 60, "Samsung", "Good Zoom Function", true));
        PRODUCTS.put(4,new Product(4,"Xiaomi 13", 1500, 100, "Xiaomi", "Noob China", false));
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(PRODUCTS.values());
    }

    @Override
    public void delete(Integer id) {
        PRODUCTS.remove(id);
    }

    @Override
    public void add(Product product) {
        PRODUCTS.put(product.getId(),product);
    }

    @Override
    public Product findById(Integer id) {
        return PRODUCTS.get(id);
    }

    @Override
    public void update(Product product) {
        PRODUCTS.put(product.getId(), product);
    }
}
