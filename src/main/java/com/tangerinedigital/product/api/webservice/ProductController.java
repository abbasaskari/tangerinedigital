package com.tangerinedigital.product.api.webservice;

import com.tangerinedigital.product.common.exception.BaseException;
import com.tangerinedigital.product.common.log.LogUtil;
import com.tangerinedigital.product.domain.model.ProductModel;
import com.tangerinedigital.product.service.business.ProductBusinessService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Abbas Askari
 *  on 14/02/2023
 *
 * This class is a controller for product Services
 */

@RestController
@RequestMapping("/springresttest")
public class ProductController {
    private static final Logger LOG = LogUtil.getDefaultLogger(ProductController.class);

    private final ProductBusinessService productBusinessService;

    /**
     * Constructor
     * @param productBusinessService
     */
    @Autowired
    public ProductController(ProductBusinessService productBusinessService) {
        this.productBusinessService = productBusinessService;
    }

    /**
     * Insert product information
     * @param productModel
     * @return ProductModel
     * @throws BaseException
     */
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping(value = "/insert")
    public ResponseEntity<ProductModel> insert(@Valid @RequestBody ProductModel productModel) throws BaseException {
        LOG.info("insert start");
        productModel = productBusinessService.insert(productModel);
        return new ResponseEntity<>(productModel, HttpStatus.OK);
    }

    /**
     * Update product information
     * @param productModel
     * @return ProductModel
     * @throws BaseException
     */
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PutMapping(value = "/update")
    public ResponseEntity<ProductModel> update(@Valid @RequestBody ProductModel productModel) throws BaseException {
        LOG.info("update start");
        productModel = productBusinessService.update(productModel);
        return new ResponseEntity<>(productModel, HttpStatus.OK);
    }

    /**
     * Delete product information
     *
     * @param productId
     * @throws BaseException
     */
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @DeleteMapping(value = "/delete")
    public void delete(@RequestParam Long productId) throws BaseException {
        LOG.info("delete start");
        productBusinessService.delete(productId);
    }

    /**
     * Get product information by productId
     *
     * @param prid
     * @return ProductModel
     */
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping(value = "/prid/{prid}")
    public ResponseEntity<ProductModel> getById(@PathVariable Long prid) {
        LOG.info("getById start");
        ProductModel productModel = productBusinessService.getByProductId(prid);
        return new ResponseEntity<>(productModel, HttpStatus.OK);
    }

    /**
     * Get product information by productId
     *
     * @return List<ProductModel>
     */
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping(value = "/prids")
    public ResponseEntity<List<ProductModel>> getAll() {
        LOG.info("getAll start");
        List<ProductModel> productModels = productBusinessService.getAll();
        return new ResponseEntity<>(productModels, HttpStatus.OK);
    }

    /**
     * It handle business exception
     * @param exception
     * @return
     */
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<String> handle(BaseException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * It handle validation exception
     * @param exception
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException exception) {
        return new ResponseEntity<>(exception.getBindingResult().getAllErrors().get(0).getDefaultMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}