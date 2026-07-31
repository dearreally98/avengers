package com.team.project.avengers.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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

    @Lob
    @Column(nullable = false)
    private String movieContent; // 영화 줄거리

    @Column
    private LocalDate releaseDate; // 영화 개봉일

    private String saveFilename;
    private String originFilename;

    // 편의 생성자
    public RecommendMovie(String movieName, String movieCast, String movieContent,LocalDate releaseDate, String saveFilename, String originFilename) {
        this.movieName = movieName;
        this.movieCast = movieCast;
        this.movieContent = movieContent;
        this.releaseDate = releaseDate;
        this.saveFilename = saveFilename;
        this.originFilename = originFilename;
    }

    public void update(String movieCast, String movieContent) {
        this.movieCast = movieCast;
        this.movieContent = movieContent;
    }

    public void attachfile(String saveFilename, String originFilename) {
        this.saveFilename = saveFilename;
        this.originFilename = originFilename;
    }
}
