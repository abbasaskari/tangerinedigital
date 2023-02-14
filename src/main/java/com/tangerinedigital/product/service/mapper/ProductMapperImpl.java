package com.tangerinedigital.product.service.mapper;


import com.tangerinedigital.product.domain.entity.Product;
import com.tangerinedigital.product.domain.model.ProductModel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abbas Askari
 * on 14/02/2023
 *
 * Implementation of ProductMapper interface that converts Product Models and Entities together
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product productModelToProductEntity(ProductModel productModel) {
        return new Product(productModel.getProductId(), productModel.getProductName());
    }

    @Override
    public ProductModel productEntityToProductModel(Product product) {
        if (product == null)
            return null;
        return new ProductModel(product.getId(), product.getName());
    }

    @Override
    public List<ProductModel> productEntityListToProductModelList(List<Product> products) {
        if (products == null)
            return null;
        List<ProductModel> productModels = new ArrayList<>();
        for (Product product : products)
            productModels.add(new ProductModel(product.getId(), product.getName()));
        return productModels;
    }
}
