package com.commerce.productinfoservices.rest;


import brave.sampler.Sampler;
import com.commerce.productinfoservices.model.Product;
import com.commerce.productinfoservices.service.ProductService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


@RestController
@RequestMapping("/products")
public class ProductInfoServices {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(ProductInfoServices.class);

    public ProductService productService;

    @Bean
    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }

    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(value = "/getProduct", headers = "Accept=application/json")
    public List<Product> getProfile(){
        log.info("get all products");
        Logger.getLogger("Clients made get all products call");
        return productService.retrieveAllProducts();
    }

    @GetMapping(value = "/getProduct/{id}", headers = "Accept=application/json")
    public Optional<Product> getSingleProfile(@PathVariable Integer id){
        log.info("product " + id + " has been called ");
        Logger.getLogger("Clients made get single products call: "+id);
        return productService.findProductById(id);
    }

    @PostMapping(value = "/postProfile", headers = "Accept=application/json")
    public ResponseEntity<Void> createProfile(@RequestBody Product product, UriComponentsBuilder uriComponentsBuilder){
        productService.createProduct(product);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/api/{id}").buildAndExpand(product.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/updateProduct", headers = "Accept=application/json")
    public ResponseEntity<String> updateProfile(@RequestBody Product currentProduct){
        log.info("product " + currentProduct + " has been called ");
        Optional<Product> updatedProduct = productService.findProductById(currentProduct.getId());
        if(updatedProduct==null){
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        productService.updateProduct(currentProduct,currentProduct.getId());
        return new ResponseEntity<String>(HttpStatus.OK);

    }

    @DeleteMapping(value = "/deleteProduct/{id}", headers = "Accept=application/json")
    public ResponseEntity<String> deleteProfile(@PathVariable Integer id){
        log.info("product " + id + " has been called ");
        Optional<Product> product = productService.findProductById(id);
        if(product==null){
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        productService.deleteProduct(id);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);

    }


}
