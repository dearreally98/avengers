package com.team.project.avengers.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "recommend_movie")
public class RecommendMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieNo; //영화번호

    @Column(length = 30, nullable = false)
    private String movieName; //영화 이름

    @Lob
    @Column(nullable = false)
    private String movieCast; //배우,감독


    @Column(length = 500)
    private String postUrl; //영화 포스터 이미지를 동적으로 받을 파일 경로 또는 URL

    @Lob
    @Column(nullable = false)
    private String movieContent; //영화 줄거리

    private String saveFilename;
    private String originFilename;

    public RecommendMovie(String movieName, String movieCast, String movieContent, String postUrl) {
        this.movieName = movieName;
        this.movieCast = movieCast;
        this.postUrl = postUrl;
        this.movieContent = movieContent;

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
