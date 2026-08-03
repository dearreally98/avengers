package com.team.project.avengers.repository;

import com.team.project.avengers.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByOrderByReviewNoDesc();

    Page<Review> findAll(Pageable pageable);

    @Query("""
        SELECT r
        FROM Review r
        WHERE (:searchType= 'title' AND r.reviewTitle LIKE CONCAT ('%',:keyword,'%'))
           OR (:searchType= 'name' AND r.reviewName LIKE CONCAT ('%',:keyword,'%'))
           OR (:searchType= 'content' AND r.reviewContent LIKE CONCAT ('%',:keyword,'%'))
        """)
    Page<Review> searchReview(
            @Param("searchType") String searchType,
            @Param("keyword") String keyword,
            Pageable pageable
    );
}
