package com.tangerinedigital.product.domain.entity;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

/**
 * Created by Abbas Askari
 * on 14/02/2023
 *
 * This class is a base entity that every entity inheritance this
 * This will can be used for persistence Time and Authority
 */

@MappedSuperclass
public class BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

}
