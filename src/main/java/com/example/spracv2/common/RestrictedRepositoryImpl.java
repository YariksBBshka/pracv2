package com.example.spracv2.common;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class RestrictedRepositoryImpl<T, ID> implements RestrictedRepository<T, ID> {

    private EntityManager entityManager;

    private final Class<T> domainClass;

    public RestrictedRepositoryImpl(Class<T> domainClass) {
        this.domainClass = domainClass;
    }

    @Override
    @Transactional
    public <S extends T> S save(S entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    @Transactional
    public List<T> findAll() {
        return entityManager.createQuery("from " +
                        domainClass.getName(),
                domainClass).getResultList();
    }

    @Override
    @Transactional
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(entityManager.find(domainClass, id));
    }
}
