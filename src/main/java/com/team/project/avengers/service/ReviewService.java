package com.team.project.avengers.service;

import com.team.project.avengers.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> reviewList();
    void reviewInsert(ReviewDTO reviewDTO);
    ReviewDTO reviewDetail(Long reviewNo);
    ReviewDTO updateReviewForm(Long reviewNo);
    void reviewUpdate(Long reviewNo, ReviewDTO reviewDTO);
    void reviewDelete(Long reviewNo);
}
