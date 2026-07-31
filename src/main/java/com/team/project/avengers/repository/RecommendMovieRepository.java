package com.team.project.avengers.repository;

import com.team.project.avengers.entity.RecommendMovie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendMovieRepository extends JpaRepository<RecommendMovie, Long> {
    // 영화 제목 이름 검색
    Page<RecommendMovie> findByMovieNameContaining(String keyword, Pageable pageable);

    // 출연진/감독 검색
    Page<RecommendMovie> findByMovieCastContaining(String keyword, Pageable pageable);

    // 제목 또는 출연진/감독 검색
    Page<RecommendMovie> findByMovieNameContainingOrMovieCastContaining(String movieName, String MovieCast, Pageable pageable);

    //
}
