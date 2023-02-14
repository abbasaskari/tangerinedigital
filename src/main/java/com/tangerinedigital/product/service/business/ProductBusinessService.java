package com.tangerinedigital.product.service.business;

import com.tangerinedigital.product.common.exception.BaseException;
import com.tangerinedigital.product.domain.model.ProductModel;

import java.util.List;

/**
 * Created by Abbas Askari
 * on 14/02/2023
 *
 * An interface that represent Product services
 */

public interface ProductBusinessService {

    /**
     * Insert product information
     *
     * @param productModel
     * @return ProductModel
     * @throws BaseException
     */
    ProductModel insert(ProductModel productModel) throws BaseException;

    /**
     * Update product information
     *
     * @param productModel
     * @return ProductModel
     * @throws BaseException
     */
    ProductModel update(ProductModel productModel) throws BaseException;

    /**
     * Delete product information
     *
     * @param productId
     * @throws BaseException
     */
    void delete(Long productId) throws BaseException;

    /**
     * Get product information by productId
     *
     * @param productId
     * @return ProductModel
     */
    ProductModel getByProductId(Long productId);

    /**
     * Get product information by productId
     *
     * @return List<ProductModel>
     */
    List<ProductModel> getAll();
}
