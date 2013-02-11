
package com.sample.core.persistence.repository;

import com.sample.core.persistence.exception.EntityNotFoundException;
import com.sample.core.persistence.model.Entity;

/**
 * Define the generic methods for Create, Read, Update and Delete operations for
 * an entity.
 *
 * @param <E>
 *            persistence entity type
 * @param <ID>
 *            primary key type of the entity
 */
public interface CrudRepository<E extends Entity> extends Repository<E> {

	/**
	 * Persists the given entity object and returns the persisted object back.
	 * It is recommended to use the returned object because save operation might
	 * have changed the entity instance.
	 *
	 * @param entity
	 * @return the saved entity
	 */
	E save(E entity);

	/**
	 * Update the entity.
	 *
	 * @param entity
	 * @return the updated entity
	 */
	E update(E entity);

	/**
	 * Saves all given entities.
	 *
	 * @param entities
	 * @return a iterable of saved entities
	 */
	Iterable<E> save(Iterable<? extends E> entities);

	/**
	 * Retries an entity by its primary key.
	 *
	 *
     * @param id
     * @return the entity with the given primary key or {@code null} if none
	 *         found
	 * @throws IllegalArgumentException
	 *             if primaryKey is {@code null}
     * @throws EntityNotFoundException
     *             if no entity is found for the given primary key
	 */
 	E findOne(long id) throws EntityNotFoundException,IllegalArgumentException;

	/**
	 * Returns whether an entity with the given id exists.
	 *
	 * @param id
	 * @return true if an entity with the given id exists, else otherwise
	 * @throws IllegalArgumentException
	 *             if primaryKey is {@code null}
	 */
	boolean exists(long id);

	/**
	 * Returns all instances of the type.
	 *
	 * @return all entities
	 */
	Iterable<E> findAll();

	/**
	 * Returns the number of entities available.
	 *
	 * @return the number of entities
	 */
	long count();

    /**
     * Deletes the entity with the given id.
     *
     * @param id
     * @throws EntityNotFoundException
     */
	void delete(long id) throws EntityNotFoundException;

	/**
	 * Deletes a given entity.
	 *
	 * @param entity
	 */
	void delete(E entity);

	/**
	 * Deletes the given entities.
	 *
	 * @param entities
	 */
	void delete(Iterable<? extends E> entities);

}
