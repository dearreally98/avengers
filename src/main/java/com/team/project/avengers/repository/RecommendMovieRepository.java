package com.team.project.avengers.repository;

import com.team.project.avengers.entity.RecommendMovie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RecommendMovieRepository extends JpaRepository<RecommendMovie, Long> {

    @Query("SELECT r FROM RecommendMovie r WHERE " +
            "(:searchType = 't' AND r.movieName LIKE %:keyword%) OR " +
            "(:searchType = 'c' AND r.movieCast LIKE %:keyword%) OR " +
            "((:searchType = '' OR :searchType IS NULL OR (:searchType <> 't' AND :searchType <> 'c')) AND (r.movieName LIKE %:keyword% OR r.movieCast LIKE %:keyword%))")
    Page<RecommendMovie> searchMovies(@Param("searchType") String searchType,
                                      @Param("keyword") String keyword,
                                      Pageable pageable);
}
