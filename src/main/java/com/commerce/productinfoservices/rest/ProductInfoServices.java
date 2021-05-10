package com.commerce.productinfoservices.rest;

import com.commerce.productinfoservices.model.Product;
import com.commerce.productinfoservices.model.ProductSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/products")
public class ProductInfoServices {

    @RequestMapping("/{productId}")
    public Product getProductInfo(@PathVariable("productId") String productId) {
        return new Product("101", "iPhone", 700, "Apple Smart Phone");

    }

}
