package com.cgi.ectp.data.dao;

import com.cgi.ectp.data.model.PetModel;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<PetModel, Integer> {
}
