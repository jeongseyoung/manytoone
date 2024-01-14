package com.example.manytoone2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.manytoone2.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByrolename(String rolename);

}
