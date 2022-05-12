package com.example.springsecurityv2.repo;

import com.example.springsecurityv2.modal.ERole;
import com.example.springsecurityv2.modal.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
