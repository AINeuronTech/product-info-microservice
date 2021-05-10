package com.commerce.productinfoservices.model;

public class ProductSummary {
    public String id;
    public String productName;
    public String productOverview;

    public ProductSummary(String id, String productName, String productOverview) {
        this.id = id;
        this.productName = productName;
        this.productOverview = productOverview;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductOverview() {
        return productOverview;
    }

    public void setProductOverview(String productOverview) {
        this.productOverview = productOverview;
    }

}
