package com.llye.sb.customannotation.repository;

import com.llye.sb.customannotation.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
