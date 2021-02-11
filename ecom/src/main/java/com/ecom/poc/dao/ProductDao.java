package com.ecom.poc.dao;

import com.ecom.poc.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends PagingAndSortingRepository<Product, Integer> {

    @Query("select count(*) from Product where productId = ?1")
    public Integer isProductExist(Integer id);
}
