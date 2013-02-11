package com.sample.core.persistence;

import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaQuery;

import com.sample.core.persistence.model.BaseEntity;

/**
 * Convenience class that manages basic JPA operations.
 * @author Sanjeeva Samaranayake
 */
public interface BasicPersistenceManager {

    <T extends BaseEntity> T create(T modelEntity);

    <T extends BaseEntity> CriteriaQuery<T> createModelCriteriaQuery(Class<T> modelEntityType);

    <T extends BaseEntity> void delete(T modelEntity);
    
    <T extends BaseEntity> List<T> findAll(Class<T> modelEntityType);

    <T extends BaseEntity> List<T> findByCriteria(CriteriaQuery<T> selectionCriteria);
    
    <T extends BaseEntity> T findById(Long modleEntityId, Class<T> modelEntityType);

    <T extends BaseEntity> List<T> findUsingNamedQuery(String queryName, Class<T> modelEntityType);
    
    <T extends BaseEntity> List<T> findUsingNamedQuery(String queryName, Map<String, Object> parameters,
        Class<T> modelEntityType);
    
    <T extends BaseEntity> List<T> findUsingQueryLanguageExpression(String qlExpression, Class<T> modelEntityType);
    
    <T extends BaseEntity> List<T> findUsingQueryLanguageExpression(String qlExpression, Map<String, Object> parameters,
        Class<T> modelEntityType);

    <T extends BaseEntity> T update(T modelEntity);
    
    <T extends BaseEntity> long count(Class<T> modelEntityType);

}
