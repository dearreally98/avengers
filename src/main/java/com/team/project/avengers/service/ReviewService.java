package com.team.project.avengers.service;

import com.team.project.avengers.dto.ReviewDTO;
import com.team.project.avengers.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> reviewList();
    Page<ReviewDTO> reviewList(Pageable pageable);
    void reviewInsert(ReviewDTO reviewDTO);
    ReviewDTO reviewDetail(Long reviewNo);
    ReviewDTO updateReviewForm(Long reviewNo);
    void reviewUpdate(Long reviewNo, ReviewDTO reviewDTO);
    boolean passwordCheck(Long reviewNo, String reviewPassword);
    void reviewDelete(Long reviewNo);
}
