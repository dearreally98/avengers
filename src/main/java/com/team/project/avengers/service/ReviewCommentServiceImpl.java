package com.team.project.avengers.service;

import com.team.project.avengers.dto.ReviewCommentDTO;
import com.team.project.avengers.entity.Review;
import com.team.project.avengers.entity.ReviewComment;
import com.team.project.avengers.repository.ReviewCommentRepository;
import com.team.project.avengers.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewCommentServiceImpl implements ReviewCommentService{
    private final ReviewCommentRepository reviewCommentRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public List<ReviewCommentDTO> reviewCommentList(Long reviewNo) {
        return reviewCommentRepository
                .findByReview_ReviewNoOrderByIdDesc(reviewNo)
                .stream()
                .map(ReviewCommentDTO::fromEntity)
                .toList();
    }

    @Override
    @Transactional
    public ReviewCommentDTO commentInsert(ReviewCommentDTO reviewCommentDTO) {
        Review review = reviewRepository.findById(reviewCommentDTO.getReviewNo())
                .orElseThrow(() -> new IllegalArgumentException(reviewCommentDTO.getReviewNo() + "번 게시글이 존재하지 않습니다."));

        ReviewComment reviewComment = reviewCommentDTO.toEntity(review);
        ReviewComment savedComment = reviewCommentRepository.save(reviewComment);

        return ReviewCommentDTO.fromEntity(savedComment);
    }
}
