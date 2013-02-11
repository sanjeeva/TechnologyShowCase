package com.sample.core.persistence.exception;

/**
 * Returns when no entity is found in the persistence data source for the given criteria.
 *
 */
public class EntityNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Name of the entity that was not found for the given criteria.
     */
    private Class entityClass;

    public EntityNotFoundException(Class entityClass, String message) {
        super(message);
        this.entityClass = entityClass;
    }

    public Class getEntityClass() {
        return entityClass;
    }
}
