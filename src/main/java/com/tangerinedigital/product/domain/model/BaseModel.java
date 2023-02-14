package com.tangerinedigital.product.domain.model;

import java.io.Serial;
import java.io.Serializable;

/**
 * Created by Abbas Askari
 * on 14/02/2023
 *
 * This class is a base model that every model inheritance this
 * This wil can be used for keeping Time, Authority and Versioning
 */

public abstract class BaseModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

}
