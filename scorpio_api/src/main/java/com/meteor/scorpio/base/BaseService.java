package com.meteor.scorpio.base;


import com.meteor.scorpio.parameter.SimpleFilterResolver;
import com.meteor.scorpio.util.BeanCopyUtil;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Date;

public abstract class BaseService<T extends BaseEntity, ID extends Serializable> {

    public abstract BaseRepository<T, ID> repository();

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Transactional(readOnly = true)
    public Page<T> filter(SimpleFilterResolver<T> filterResolver) {
        return repository().findAll(filterResolver.genSpecification(), filterResolver.genPageRequest());
    }

    public T findById(ID id) {
        return repository().findById(id).get();
    }

    @Transactional
    public T save(T entity) {
        return repository().save(entity);
    }

    @Transactional
    public T update(T entity) {
        BaseEntity entityBase = getEntityManager().find(entity.getClass(),entity.getId());
        BeanCopyUtil.beanCopy(entity,entityBase);
        entityBase.setUpdateTime(new Date());
        getEntityManager().merge(entityBase);
        getEntityManager().flush();
        return (T) entityBase;
    }

    @Transactional
    public void delete(T entity) {
        repository().delete(entity);
    }

    @Transactional
    public void deleteById(ID id) {
        repository().deleteById(id);
    }

}


