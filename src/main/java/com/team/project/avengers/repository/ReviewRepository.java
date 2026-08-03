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

    /*@Query("""
        SELECT r
        FROM Review r
        WHERE (:searchType= 'reviewTitle' AND r.reviewTitle LIKE CONCAT ('%',:keyword,'%'))
           OR (:searchType= 'reviewName' AND r.reviewName LIKE CONCAT ('%',:keyword,'%'))
           OR (:searchType= 'reviewContent' AND r.reviewContent LIKE CONCAT ('%',:keyword,'%'))
        """)*/

    Page<Review> findAll(Pageable pageable);
}
