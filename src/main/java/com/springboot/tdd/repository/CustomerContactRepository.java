package com.springboot.tdd.repository;

import com.springboot.tdd.domain.CustomerContact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerContactRepository extends CrudRepository<CustomerContact, Long> {

	CustomerContact findByEmail(String email);
}
