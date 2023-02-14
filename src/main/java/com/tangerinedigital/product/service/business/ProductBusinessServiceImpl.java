package com.tangerinedigital.product.service.business;

import com.tangerinedigital.product.common.exception.BaseException;
import com.tangerinedigital.product.common.log.LogUtil;
import com.tangerinedigital.product.domain.entity.Product;
import com.tangerinedigital.product.domain.model.ProductModel;
import com.tangerinedigital.product.service.dao.ProductDao;
import com.tangerinedigital.product.service.mapper.ProductMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Abbas Askari
 * on 14/02/2023
 *
 * Implementation of ProductBusinessService interface that represent Product services
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductBusinessServiceImpl implements ProductBusinessService {
    private final ProductDao productDao;
    private final ProductMapper productMapper;

    private static final Logger LOG = LogUtil.getDefaultLogger(ProductBusinessServiceImpl.class);

    @Autowired
    public ProductBusinessServiceImpl(ProductDao productDao, ProductMapper productMapper) {
        this.productDao = productDao;
        this.productMapper = productMapper;
    }

    @Override
    public ProductModel insert(ProductModel productModel) throws BaseException {
        LOG.info("insert start");

        Product product = productDao.findByName(productModel.getProductName());

        if (product != null)
            throw new BaseException("Product Name is duplicate.");


        product = productMapper.productModelToProductEntity(productModel);
        product = productDao.save(product);
        return productMapper.productEntityToProductModel(product);
    }

    @Override
    public ProductModel update(ProductModel productModel) throws BaseException{
        LOG.info("update start");

        Product product = productDao.findById(productModel.getProductId()).orElse(null);

        if (product == null)
            throw new BaseException("Product not found.");

        if (!product.getName().equals(productModel.getProductName()))
        {
            Product productName = productDao.findByName(productModel.getProductName());

            if (productName != null)
                throw new BaseException("Product name is duplicate.");
        }

        product = productMapper.productModelToProductEntity(productModel);
        product = productDao.save(product);
        return productMapper.productEntityToProductModel(product);
    }

    @Override
    public void delete(Long productId) throws BaseException {
        LOG.info("update start");

        Product product = productDao.findById(productId).orElse(null);

        if (product == null)
            throw new BaseException("Product not found.");

        productDao.delete(product);
    }

    @Override
    public ProductModel getByProductId(Long productId) {
        LOG.info("getById start");

        return productMapper.productEntityToProductModel(productDao.findById(productId).orElse(null));
    }

    @Override
    public List<ProductModel> getAll() {
        LOG.info("getAll start");

        return productMapper.productEntityListToProductModelList(productDao.findAll());
    }
}
