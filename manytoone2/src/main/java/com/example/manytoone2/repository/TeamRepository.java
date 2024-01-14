package com.example.manytoone2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.manytoone2.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    Optional<Team> findByTeamname(String teamname);
}
