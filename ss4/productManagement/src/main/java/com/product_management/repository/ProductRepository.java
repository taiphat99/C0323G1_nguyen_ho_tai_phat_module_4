package com.product_management.repository;

import com.product_management.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> getAll() {
        TypedQuery<Product> query = entityManager.createQuery("from Product", Product.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Product product = findById(id);
        entityManager.remove(product);
    }

    @Transactional
    @Override
    public void add(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findById(Integer id) {
        return entityManager.find(Product.class, id);
    }

    @Transactional
    @Override
    public void update(Product product) {
        Product product1 = findById(product.getId());
        entityManager.merge(product1);
    }
}
