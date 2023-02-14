package com.tangerinedigital.product.service.dao;

import com.tangerinedigital.product.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Abbas Askari
 * on 14/02/2023
 *
 * A repository for managing Product entity
 */

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {

    /**
     * Find a product by product name
     * @param productName
     * @return Product
     */
    @Query("SELECT product FROM Product product WHERE product.name = :productName")
    Product findByName(@Param("productName") String productName);

}
