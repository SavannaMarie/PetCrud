package com.cgi.ectp.data.dao;

import com.cgi.ectp.data.model.PetModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetJPARepository extends JpaRepository<PetModel, Integer> {
}
