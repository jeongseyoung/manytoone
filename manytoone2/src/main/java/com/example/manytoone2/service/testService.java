package com.example.manytoone2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.manytoone2.dto.MemberDto;
import com.example.manytoone2.entity.Member;
import com.example.manytoone2.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class testService {

    private final MemberRepository memberRepository;

    public void getMemberList1() {
        /*
         * 단순히 findAll을 하면 쿼리가 여러개 발생 -> Member select, Role select, Team select..
         * member정보가 필요하여 findAll 하면 team, role정보를 가져오기 위해 여러쿼리를 동시에 날려버리는 상황.
         */
        List<Member> members = memberRepository.findAll();
    }

    public void getMemberList2() {
        System.out.println("getMemberList2: ");

        /*
         * 방법 1.
         * MemberDto(Member entity의 member정보만 Dto로 따로 만듦) + LAZY(fetch) + ModelMapper를
         * 이용. -> Member정보만 한개의 쿼리로 가져올 수 있다.
         * 하지만 Memeber정보만 가져오기 때문에 team 혹은 role이 필요할 경우 쿼리를 추가로 발생 시켜야 함.
         */
        ModelMapper modelMapper = new ModelMapper();
        // List<MemberDto> memberDto =
        memberRepository.findAll().stream().map(m -> modelMapper.map(m, MemberDto.class))
                .collect(Collectors.toList()).forEach(m -> System.out.println(m.getMembername()));

    }

    public void getMemberList3() {
        /*
         * 방법 2.
         * 하나의 쿼리로 member의 정보, team, role 전부 가져오는 방법.
         * Member entity에 @NamedEntityGraph를 사용한다.
         */
        List<Member> member = memberRepository.findAll();
        member.stream().map(m -> m.getRole().getRolename()).collect(Collectors.toList())
                .forEach(m -> System.out.println(m));

    }

}
