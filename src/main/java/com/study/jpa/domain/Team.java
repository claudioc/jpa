package com.study.jpa.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Team {
    @Id
    @GeneratedValue
    private String id;

    @Column()
    private String name;

    @Builder
    public Team(String name) {
        this.name = name;
    }
}
