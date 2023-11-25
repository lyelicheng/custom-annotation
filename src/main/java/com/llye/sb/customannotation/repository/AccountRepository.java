package com.llye.sb.customannotation.repository;

import com.llye.sb.customannotation.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Page<Account> findByCustomerId(Long customerId, Pageable pageable);
    Optional<Account> findByIdAndCustomerId(Long id, Long customerId);
}
