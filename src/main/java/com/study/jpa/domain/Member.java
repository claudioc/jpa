package com.study.jpa.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue
    private String id;

    @Column()
    private String userName;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @Builder
    public Member(String userName, Team team) {
        this.userName = userName;
        this.team = team;
    }
}
