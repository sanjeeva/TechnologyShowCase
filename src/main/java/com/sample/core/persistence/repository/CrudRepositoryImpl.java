package com.sample.core.persistence.repository;

import com.sample.core.persistence.BasicPersistenceManager;
import com.sample.core.persistence.exception.EntityNotFoundException;
import com.sample.core.persistence.model.BaseEntity;
import com.sample.core.utilities.lang.CollectionUtilities;

import java.util.ArrayList;
import java.util.List;

/**
 * Supporting calss to give CURD operation for an given entity off the shelf.
 * 
 */
public class CrudRepositoryImpl<E extends BaseEntity> implements CrudRepository<E> {
	
	public BasicPersistenceManager persistenceManager;
	private Class<E> entityClass;

	public CrudRepositoryImpl(BasicPersistenceManager persistenceMgr,
			Class<E> entityClass) {
		this.persistenceManager = persistenceMgr;
		this.entityClass = entityClass;
		
	}

	@Override
	public E save(E entity) {
		return persistenceManager.create(entity);
	}

	@Override
	public Iterable<E> save(Iterable<? extends E> entities) {		
		List<E> savedEntities = null;
		if(CollectionUtilities.isNotEmpty(entities)) {
			savedEntities = new ArrayList<E>();
			for (E entity : entities) {
				savedEntities.add(persistenceManager.create(entity));
			}
		}
		return savedEntities;
	}

	@Override
	public E findOne(long id) throws EntityNotFoundException {
        E entity = persistenceManager.findById(id, entityClass);
        if(entity!= null)
            return entity;
        throw new EntityNotFoundException(entityClass,"No "+entityClass+" is found for the primary key :"+id);
	}

	@Override
	public boolean exists(long id) {
        try {
            findOne(id);
        } catch (EntityNotFoundException e) {
            return false;
        }
        return true;
    }

	@Override
	public Iterable<E> findAll() {
		return persistenceManager.findAll(entityClass, null);
	}

	@Override
	public long count() {
		return persistenceManager.count(entityClass);
	}

	@Override
	public void delete(long id) throws EntityNotFoundException {
            persistenceManager.delete(findOne(id));
    }

	@Override
	public void delete(E entity) {
		persistenceManager.delete(entity);
	}

	@Override
	public void delete(Iterable<? extends E> entities) {
		// TODO Auto-generated method stub
	}

    @Override
    public E update(E entity) {
        return persistenceManager.update(entity);
    }

}
