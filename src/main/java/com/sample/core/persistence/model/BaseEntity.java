package com.sample.core.persistence.model;

/**
 * Base class which houses common persistence related structural information.
 * 
 */

public abstract class BaseEntity implements Entity {

    private static final long serialVersionUID = 1L;

    private Long id;

    public BaseEntity() {
    }

    
    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof BaseEntity)) {
            return false;
        }
        BaseEntity other = (BaseEntity) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BaseEntity [id=").append(id).append("]");
        return builder.toString();
    }
}
