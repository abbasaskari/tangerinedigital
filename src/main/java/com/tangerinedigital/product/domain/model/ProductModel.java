package com.tangerinedigital.product.domain.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Abbas Askari
 * on 14/02/2023
 *
 * A model for keeping product request information
 */

public class ProductModel extends BaseModel {

    private Long productId;

    @NotNull(message = "Product name is null.")
    @Size(message = "Product name size is wrong.", min = 1, max = 255)
    private String productName;

    public ProductModel() {
    }

    public ProductModel(Long productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
