package com.team.project.avengers.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "recommend_movie")
public class RecommendMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieNo; // 영화번호

    @Column(length = 30, nullable = false)
    private String movieName; // 영화 이름

    @Lob
    @Column(nullable = false)
    private String movieCast; // 배우, 감독

    @Column(length = 500)
    private String postUrl; // 포스터 URL 또는 경로

    @Lob
    @Column(nullable = false)
    private String movieContent; // 영화 줄거리

    private String saveFilename;
    private String originFilename;

    // 편의 생성자
    public RecommendMovie(String movieName, String movieCast, String postUrl, String movieContent, String saveFilename, String originFilename) {
        this.movieName = movieName;
        this.movieCast = movieCast;
        this.postUrl = postUrl;
        this.movieContent = movieContent;
        this.saveFilename = saveFilename;
        this.originFilename = originFilename;
    }

    public void update(String movieCast, String movieContent, String postUrl) {
        this.movieCast = movieCast;
        this.movieContent = movieContent;
        this.postUrl = postUrl;
    }

    public void attachfile(String saveFilename, String originFilename) {
        this.saveFilename = saveFilename;
        this.originFilename = originFilename;
    }
}
