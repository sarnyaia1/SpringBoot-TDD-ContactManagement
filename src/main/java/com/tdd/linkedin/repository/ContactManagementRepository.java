package com.tdd.linkedin.repository;

import com.tdd.linkedin.model.CustomerContact;
import org.springframework.data.repository.CrudRepository;

public interface ContactManagementRepository extends CrudRepository<CustomerContact, Long> {

}