package com.example.spracv2.common;


import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface RestrictedRepository<T, ID> {
    <S extends T> S save(S entity);
    List<T> findAll();
    Optional<T> findById(ID id);
}

