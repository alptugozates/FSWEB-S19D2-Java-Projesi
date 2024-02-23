package com.workintech.JavaSpringRestApi.repository;

import com.workintech.JavaSpringRestApi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByAuthority(String authority);
}
