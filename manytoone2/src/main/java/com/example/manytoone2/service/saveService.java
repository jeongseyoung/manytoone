package com.example.manytoone2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.manytoone2.entity.Member;
import com.example.manytoone2.entity.Role;
import com.example.manytoone2.entity.Team;
import com.example.manytoone2.repository.MemberRepository;
import com.example.manytoone2.repository.RoleRepository;
import com.example.manytoone2.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class saveService {
    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;
    private final TeamRepository teamRepository;

    public void save() {

        List<Role> rolelist = roleRepository.findAll();
        List<Team> teamlist = teamRepository.findAll();

        Member A = new Member();
        A.setMembername("A");
        A.setRole(rolelist.get(0));
        A.setTeam(teamlist.get(1));
        memberRepository.save(A);

        Member B = new Member();
        B.setMembername("B");
        B.setRole(rolelist.get(1));
        B.setTeam(teamlist.get(3));
        memberRepository.save(B);

        Member C = new Member();
        C.setMembername("C");
        C.setRole(rolelist.get(1));
        C.setTeam(teamlist.get(2));
        memberRepository.save(C);

        Member D = new Member();
        D.setMembername("D");
        D.setRole(rolelist.get(3));
        D.setTeam(teamlist.get(2));
        memberRepository.save(D);

        Member E = new Member();
        E.setMembername("E");
        E.setRole(rolelist.get(2));
        E.setTeam(teamlist.get(1));
        memberRepository.save(E);
    }
}
