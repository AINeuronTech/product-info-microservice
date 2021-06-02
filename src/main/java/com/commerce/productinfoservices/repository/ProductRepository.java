package com.commerce.productinfoservices.repository;

import com.commerce.productinfoservices.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {

}
