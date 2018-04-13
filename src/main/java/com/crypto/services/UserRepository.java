package com.crypto.services;

import com.crypto.entities.DBUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
  public interface UserRepository extends JpaRepository<DBUser, Integer> {
  }
