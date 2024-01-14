package com.example.manytoone2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.manytoone2.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findBymembername(String membername);

    @EntityGraph("MEMBERwithTEAMandROLE")
    List<Member> findAll();
}
