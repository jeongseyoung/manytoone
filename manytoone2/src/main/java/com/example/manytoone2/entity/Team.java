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
@Table(name = "ttt")
public class Team {
    @Id
    @GeneratedValue
    private int id;
    private String teamname;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    List<Member> memberlist = new ArrayList<>();

    public void addMember(Member member) {
        this.memberlist.add(member);
        member.updateTeam(this);
    }
}
