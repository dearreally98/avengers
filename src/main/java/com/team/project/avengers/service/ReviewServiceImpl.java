package com.team.project.avengers.service;

import com.team.project.avengers.dto.ReviewDTO;
import com.team.project.avengers.entity.Review;
import com.team.project.avengers.repository.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;

    @Override
    public List<ReviewDTO> reviewList() {
        return reviewRepository.findAllByOrderByReviewNoDesc()
                .stream()
                .map(ReviewDTO::fromEntity)
                .toList();
    }

    @Override
    @Transactional
    public void reviewInsert(ReviewDTO reviewDTO) {
        Review review= reviewDTO.toEntity();
        reviewRepository.save(review);
    }
    private Review getReview(Long reviewNo){
        return reviewRepository.findById(reviewNo)
                .orElseThrow(()->
                        new EntityNotFoundException(reviewNo + "번 게시글이 존재하지 않습니다."));
    }

    @Override
    @Transactional
    public ReviewDTO reviewDetail(Long reviewNo) {
        Review review= getReview(reviewNo);
        review.addHit();
        return ReviewDTO.fromEntity(review);
    }

    @Override
    public ReviewDTO updateReviewForm(Long reviewNo) {
        Review review= getReview(reviewNo);
        return ReviewDTO.fromEntity(review);
    }

    @Override
    @Transactional
    public void reviewUpdate(Long reviewNo, ReviewDTO reviewDTO) {
        Review review= getReview(reviewNo);
        review.reviewUpdate(reviewDTO.getReviewTitle(), reviewDTO.getReviewContent());

        if(reviewDTO.getReviewPassword() != null && !reviewDTO.getReviewPassword().isBlank()){
            review.passwordChange(reviewDTO.getReviewPassword());
        }
    }

    @Override
    @Transactional
    public void reviewDelete(Long reviewNo) {
        Review review= getReview(reviewNo);
        reviewRepository.delete(review);
    }
}
