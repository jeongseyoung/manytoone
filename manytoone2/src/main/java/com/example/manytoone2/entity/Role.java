package com.example.manytoone2.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rr")
public class Role {
    @Id
    @GeneratedValue
    private int id;
    private String rolename;

    public Role(String rolename) {
        this.rolename = rolename;
    }

    // 여기서 주인은 Member가 주인? (Member의 Role role 이 주인?) , mappedBy로 주인설정.
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    List<Member> memberlist = new ArrayList<>();

    public void addMember(Member member) {
        this.memberlist.add(member);
        member.updateRole(this);
    }
}
