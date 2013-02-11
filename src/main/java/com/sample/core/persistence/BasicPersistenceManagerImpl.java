package com.sample.core.persistence;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sample.core.persistence.model.BaseEntity;
import com.sample.core.utilities.lang.CollectionUtilities;

/**
 * @author Sanjeeva Samaranayake
 */
@Transactional
public class BasicPersistenceManagerImpl implements BasicPersistenceManager {

    private EntityManager customJpaEntityManager;

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager injectedJpaEntityManager;

    
    @Override
    public <T extends BaseEntity> T create(T modelEntity) {
        getUsableEntityManager().persist(modelEntity);
        return modelEntity;
    }

    
    @Override
    public <T extends BaseEntity> CriteriaQuery<T> createModelCriteriaQuery(Class<T> modelEntityType) {
        return getUsableEntityManager().getCriteriaBuilder().createQuery(modelEntityType);
    }

    
    @Override
    public <T extends BaseEntity> void delete(T modelEntity) {
        Object managedModelObject = findById(modelEntity.getId(), modelEntity.getClass());
        getUsableEntityManager().remove(managedModelObject);
    }

    private void fillParameters(TypedQuery<?> query, Map<String, Object> parameters) {
        if (query != null) {
            Set<Parameter<?>> queryParameters = query.getParameters();

            if (CollectionUtilities.isNotEmpty(queryParameters) && CollectionUtilities.isNotEmpty(parameters)) {
                for (Parameter<?> parameter : queryParameters) {
                    query.setParameter(parameter.getName(), parameters.get(parameter.getName()));
                }
            }
        }
    }

    
    @Override
    public <T extends BaseEntity> T findById(Long modleEntityId, Class<T> modelEntityType) {
        return getUsableEntityManager().find(modelEntityType, modleEntityId);
    }

    

    private EntityManager getUsableEntityManager() {
        if (this.customJpaEntityManager != null) {
            return this.customJpaEntityManager;
        } else {
            return this.injectedJpaEntityManager;
        }
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        if (entityManagerFactory != null) {
            this.customJpaEntityManager = entityManagerFactory.createEntityManager();
        }
    }

   
    @Override
    public <T extends BaseEntity> T update(T modelEntity) {
        return getUsableEntityManager().merge(modelEntity);
    }

    
    @Transactional(readOnly = true)
    @Override
    public <T extends BaseEntity> long count(Class<T> entityClass) {
        CriteriaBuilder criteriaBuilder = getUsableEntityManager().getCriteriaBuilder();
        CriteriaQuery<Long> countCriteria = criteriaBuilder.createQuery(Long.class);
        countCriteria.select(criteriaBuilder.countDistinct(countCriteria.from(entityClass)));
        return getUsableEntityManager().createQuery(countCriteria).getSingleResult();
    }

    @Override
    public <T extends BaseEntity> List<T> findAll(Class<T> modelEntityType) {
        return findAll(modelEntityType, null);
    }

    @Override
    public <T extends BaseEntity> List<T> findByCriteria(CriteriaQuery<T> selectionCriteria) {
        return findByCriteria(selectionCriteria, null);
    }

    @Override
    public <T extends BaseEntity> List<T> findUsingNamedQuery(String queryName, Class<T> modelEntityType) {
        return findUsingNamedQuery(queryName, modelEntityType, null);
    }

    @Override
    public <T extends BaseEntity> List<T> findUsingNamedQuery(String queryName, Map<String, Object> parameters,
        Class<T> modelEntityType) {
        return findUsingNamedQuery(queryName, parameters, modelEntityType, null);
    }

    @Override
    public <T extends BaseEntity> List<T> findUsingQueryLanguageExpression(String qlExpression, Class<T> modelEntityType) {
        return findUsingQueryLanguageExpression(qlExpression, modelEntityType, null);
    }

    @Override
    public <T extends BaseEntity> List<T> findUsingQueryLanguageExpression(String qlExpression,
        Map<String, Object> parameters, Class<T> modelEntityType) {
        return findUsingQueryLanguageExpression(qlExpression, parameters, modelEntityType, null);
    }
}
