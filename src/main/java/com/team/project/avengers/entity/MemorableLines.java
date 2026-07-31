package com.team.project.avengers.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "avengers_memorable")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemorableLines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMORABLE_NO")
    private Long memoNo; // 아이디 번호

    @Column(length = 30, nullable = false)
    private String nickname; // 닉네임

    @Column(nullable = false)
    private String actorName; // 배우 이름

    @Column(nullable = false)
    private String title; // 제목

    @Lob
    @Column
    private String content; // 내용

    private int good = 0; // 추천수

    @Column(length = 100, nullable = false)
    private String password; // 비밀번호

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createTime; // 작성일

    public MemorableLines(String nickname, String actorName, String title, String content, String password) { // 생성자
        this.nickname = nickname;
        this.actorName = actorName;
        this.title = title;
        this.content = content;
        this.password = password;
    }

    public void update(String title, String content) { // 제목과 내용을 수정
        this.title = title;
        this.content = content;
    }

    public void increaseGood() { // 추천수 증가
        this.good++;
    }
}
