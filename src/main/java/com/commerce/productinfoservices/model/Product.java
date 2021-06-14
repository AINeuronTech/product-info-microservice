package com.commerce.productinfoservices.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Product")
public class Product {

    @Id
    public int id;
    public String name;
    public String price;
}
