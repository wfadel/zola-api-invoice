package com.zola.invoice.repository;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface ZolaRepository<T, ID extends Serializable> extends Repository<T, ID>{
	  <S extends T> S save(S entity);
}
