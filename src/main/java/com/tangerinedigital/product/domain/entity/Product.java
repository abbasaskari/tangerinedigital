package com.tangerinedigital.product.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Abbas Askari
 * on 14/02/2023
 *
 * An entity for persistence Product information
 */

@Entity
@Table(name = "PRODUCT"
)
public class Product extends BaseEntity {

    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NAME", nullable = false, length = 255, unique = true)
    private String name;

    public Product() {
    }

    public Product(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long productId) {
        this.id = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String productName) {
        this.name = productName;
    }
}
