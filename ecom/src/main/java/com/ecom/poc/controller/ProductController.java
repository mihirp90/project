package com.ecom.poc.controller;

import com.ecom.poc.model.AuthenticationBean;
import com.ecom.poc.model.Product;
import com.ecom.poc.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    Logger logger = LoggerFactory.getLogger(ProductController.class.getName());

    /*
        Rest API to get all Product Details
    */

    @GetMapping("/login")
    public ResponseEntity<AuthenticationBean> login(){
        AuthenticationBean authenticationBean = new AuthenticationBean();
        authenticationBean.setMessage("Successful logged in");
        return new ResponseEntity<>(authenticationBean, HttpStatus.OK);
    }

    @GetMapping( path = "/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        logger.info("Calling service to get all products information");
        List<Product> products = productService.getAllProduct();
        if(!products.isEmpty())
            return new ResponseEntity<>(products, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.OK);
    }
    /*
    * Rest Api to add new product
    * */
    @PostMapping(path = "/add")
    public ResponseEntity<?> addNewProduct(@RequestBody Product product){
        logger.info("Calling service to add new product");
        Product response = productService.addNewProduct(product);
        if(response != null){
            return new ResponseEntity(response, HttpStatus.OK);
        }
        return new ResponseEntity<>("Issue while adding product", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*
    * Rest Api to get product details based on product Id
    * */
    @GetMapping(path = "/product")
    public ResponseEntity<?> getProductById(@RequestParam(name = "productId") Integer productId){
        logger.info("calling service to get product by id");
        Product product = productService.getProductById(productId);
        if(product != null)
             return new ResponseEntity<Product>(product, HttpStatus.OK);
        else
            return new ResponseEntity<String>("Product Not found for given Id", HttpStatus.BAD_REQUEST);
    }

    @GetMapping (path = "/sort/products")
    public ResponseEntity<List<Product>> getAllProductsInSorted(
            @RequestParam(defaultValue = "0", name = "pageNo") Integer pageNo,
            @RequestParam(defaultValue = "10", name = "pageSize") Integer pageSize,
            @RequestParam(defaultValue = "productName", name = "sortBy") String sortBy)
    {
        logger.info("calling service to get all product information in sorted manner");
        List<Product> list = productService.getAllProductInSortedOrder(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
    }
}
