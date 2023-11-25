package com.llye.sb.customannotation.repository;

import com.llye.sb.customannotation.CustomQuery;
import com.llye.sb.customannotation.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path="accounts")
public interface AccountRepository extends JpaRepository<Account, Long> {
    @CustomQuery
    Page<Account> findByCustomerId(Long customerId, Pageable pageable);
    @CustomQuery
    Optional<Account> findByIdAndCustomerId(Long id, Long customerId);
}
