package com.example.manytoone2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Table(name = "mmm")
@NamedEntityGraph(name = "MEMBERwithTEAMandROLE", attributeNodes = {
        @NamedAttributeNode("team"),
        @NamedAttributeNode("role")
})
public class Member {
    @Id
    @GeneratedValue
    private int id;
    private String membername;

    // LAZY -> 멤버를 FINDALL하면 LAZY는 role, team을 빼고 가져옴.
    // ROLE을 참조하면 그때 SELECT쿼리 실행됨?. 에러남?
    // EAGER -> 멤버를 FINDALL하면 ROLE TEAM 전부 조회 ? 쿼리 여러개 날림?
    @ManyToOne(fetch = FetchType.EAGER) // 여기서 조인설정
    @JoinColumn(name = "role_id") // 이건 걍 column name?
    private Role role; // -> 이거하고 mappedBy해야됨

    public void updateRole(Role role) {
        this.role = role;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    private Team team;

    public void updateTeam(Team team) {
        this.team = team;
    }

    public Member(String membername) {
        this.membername = membername;
    }
}
