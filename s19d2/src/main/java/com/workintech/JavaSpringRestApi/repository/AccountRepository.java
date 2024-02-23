package com.workintech.JavaSpringRestApi.repository;

import com.workintech.JavaSpringRestApi.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
