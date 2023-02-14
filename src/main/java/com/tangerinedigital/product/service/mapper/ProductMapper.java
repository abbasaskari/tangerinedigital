package com.tangerinedigital.product.service.mapper;


import com.tangerinedigital.product.domain.entity.Product;
import com.tangerinedigital.product.domain.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abbas Askari
 * on 14/02/2023
 *
 * An interface that converts Product Models and Entities together
 */
public interface ProductMapper {

    /**
     * Map ProductM Model to Product Entity
     * @param productModel
     * @return Product
     */
    Product productModelToProductEntity(ProductModel productModel);

    /**
     * Map Product Entity to Product Model
     * @param product
     * @return productModel
     */
    ProductModel productEntityToProductModel(Product product);

    /**
     * Map Product Entity List to Product Model List
     * @param products
     * @return List<ProductModel>
     */
    List<ProductModel> productEntityListToProductModelList(List<Product> products);
}
