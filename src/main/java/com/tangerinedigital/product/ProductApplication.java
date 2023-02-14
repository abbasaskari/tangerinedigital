package com.tangerinedigital.product;

import com.tangerinedigital.product.common.log.LogUtil;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Abbas Askari
 * on 14/02/2023 */
@SpringBootApplication
public class ProductApplication {
	private static final Logger LOG = LogUtil.getDefaultLogger(ProductApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
		LOG.info("Application is ready!");
	}
}
