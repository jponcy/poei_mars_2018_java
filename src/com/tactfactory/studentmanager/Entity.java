
package com.tactfactory.studentmanager;

import java.io.Serializable;

public class Entity implements Serializable {

    private static final long serialVersionUID = 4382117642965253689L;

    private Integer id;

    /** @return */
    public Integer getId() {
        return id;
    }

    /** @param id
     * @return */
    public Entity setId(Integer id) {
        this.id = id;
        return this;
    }
}
