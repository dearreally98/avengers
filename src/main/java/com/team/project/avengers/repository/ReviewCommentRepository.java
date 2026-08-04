package com.team.project.avengers.repository;

import com.team.project.avengers.entity.ReviewComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewCommentRepository extends JpaRepository<ReviewComment, Long> {
    Page<ReviewComment> findByReviewReviewNo(Long reviewNo, Pageable pageable);
}
