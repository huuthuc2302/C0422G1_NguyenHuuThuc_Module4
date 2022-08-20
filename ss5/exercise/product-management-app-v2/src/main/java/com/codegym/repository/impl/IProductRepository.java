package com.codegym.repository.impl;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class IProductRepository implements com.codegym.repository.IProductRepository {


    @Override
    public List<Product> findAll() {
        List<Product> productList = BaseRepository.entityManager.createQuery("select s from product s", Product.class).getResultList();
        return productList;
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(Long id) {
        Product product = BaseRepository.entityManager.createQuery("select s from product s where s.id = ?1", Product.class).setParameter(1, id).getSingleResult();
        return product;
    }

    @Override
    public void update(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void remove(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(findById(product.getId()));
        entityTransaction.commit();
    }

    @Override
    public List<Product> searchProductByName(Product product) {
        List<Product> searchList = BaseRepository.entityManager.
                createQuery("select s from product s where s.name like ?1", Product.class).
                setParameter(1, "%" + product.getName() + "%").getResultList();
        return searchList;
    }
}
