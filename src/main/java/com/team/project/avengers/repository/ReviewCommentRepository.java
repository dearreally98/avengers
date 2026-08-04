package com.team.project.avengers.repository;

import com.team.project.avengers.entity.ReviewComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewCommentRepository extends JpaRepository<ReviewComment, Long> {
    List<ReviewComment> findByReview_ReviewNoOrderByIdDesc(Long reviewNo);
    List<ReviewComment> findByNickname(String nickname);
    long countByReview_ReviewNo(Long reviewNo);
}
