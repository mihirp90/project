package com.ecom.poc.services;

import com.ecom.poc.dao.ProductDao;
import com.ecom.poc.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    Logger logger = LoggerFactory.getLogger(ProductService.class.getName());

    @Autowired
    private ProductDao productDao;

    public List<Product> getAllProduct() {
        return (List<Product>) productDao.findAll();
    }

    @Transactional
    public Product addNewProduct(Product product) {
        logger.info("Adding product in database ");
        logger.info("Product information {} ", product.toString());
        return productDao.save(product);
    }

    public Product getProductById(Integer productId) {
        return Optional.of(productDao.findById(productId)).get().orElse(null);
    }

    public List<Product> getAllProductInSortedOrder(Integer pageNo, Integer pageSize, String sortBy) {

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Product> pagedResult = productDao.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Product>();
        }
    }
}
