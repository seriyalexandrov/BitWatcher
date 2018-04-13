package com.crypto.services;


import com.crypto.entities.DBCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
  public interface CurrencyRepository extends JpaRepository<DBCurrency, Integer> {

  }

