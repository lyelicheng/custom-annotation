package com.llye.sb.customannotation.repository;

import com.llye.sb.customannotation.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="customers")
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
