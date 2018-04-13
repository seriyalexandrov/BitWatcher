package com.crypto.services;


import com.crypto.entities.DBPicked;
import com.crypto.entities.DBUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PickedRepository  extends JpaRepository<DBPicked, Integer> {
   List<DBPicked>  findAllByUser (DBUser user);
}
