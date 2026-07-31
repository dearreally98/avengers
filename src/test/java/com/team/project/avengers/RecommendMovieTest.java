package com.team.project.avengers;

import com.team.project.avengers.entity.RecommendMovie;
import com.team.project.avengers.repository.RecommendMovieRepository;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Commit;

import java.time.LocalDate;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
public class RecommendMovieTest {
    @Autowired
    private RecommendMovieRepository recommendMovieRepository;

    private void printMovie(RecommendMovie recommendMovie) {
        log.info("영화 번호: {}", recommendMovie.getMovieNo());
        log.info("영화 제목: {}", recommendMovie.getMovieName());
        log.info("영화 감독/배우: {}", recommendMovie.getMovieCast());
        log.info("영화 내용: {}", recommendMovie.getMovieContent());
        log.info("영화 개봉일: {}", recommendMovie.getReleaseDate());
        log.info("저장 파일명: {}", recommendMovie.getSaveFilename());
    }

    @Test
    @Commit
    public void movieListInsertTest() {
        RecommendMovie recommendMovie1 = RecommendMovie.builder()
                .movieName("캡틴 아메리카: 시빌 워")
                .movieCast("안소니 루소")
                .movieContent("어벤져스 VS 어벤져스 분열은 시작되었다! 어벤져스와 관련된 사고로 부수적인 피해가 일어나자 정부는 어벤져스를 관리하고 감독하는 시스템인 일명 ‘슈퍼히어로 등록제’를 내놓는다. 어벤져스 내부는 정부의 입장을 지지하는 찬성파(팀 아이언맨)와 이전처럼 정부의 개입 없이 자유롭게 인류를 보호해야 한다는 반대파(팀 캡틴)로 나뉘어 대립하기 시작하는데...")
                .releaseDate(LocalDate.parse("2016-04-27"))
                .saveFilename("캡아 시빌워.jpg")
                .build();


        RecommendMovie saveMovie1 = recommendMovieRepository.save(recommendMovie1);

        printMovie(saveMovie1);

        RecommendMovie recommendMovie2 = RecommendMovie.builder()
                .movieName("")
                .movieCast("")
                .movieContent("")
                .releaseDate(LocalDate.parse(""))
                .saveFilename("")
                .build();


        RecommendMovie saveMovie2 = recommendMovieRepository.save(recommendMovie2);

        printMovie(saveMovie2);


        RecommendMovie recommendMovie3 = RecommendMovie.builder()
                .movieName("")
                .movieCast("")
                .movieContent("")
                .releaseDate(LocalDate.parse(""))
                .saveFilename("")
                .build();


        RecommendMovie saveMovie3 = recommendMovieRepository.save(recommendMovie3);

        printMovie(saveMovie3);
    }


}
