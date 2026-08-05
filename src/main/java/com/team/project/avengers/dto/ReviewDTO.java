package com.team.project.avengers.dto;

import com.team.project.avengers.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private Long reviewNo;
    private String reviewTitle;
    private String reviewName;
    private String reviewContent;
    private String reviewPassword;

    private MultipartFile uploadFile;
    private String savedFileName;
    private String originFileName;

    private LocalDate reviewCreateAt;
    private int reviewHit;

    public Review toEntity(){
        return new Review(reviewTitle, reviewName, reviewContent, reviewPassword);
    }

    public static ReviewDTO fromEntity(Review review){
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setReviewNo(review.getReviewNo());
        reviewDTO.setReviewTitle(review.getReviewTitle());
        reviewDTO.setReviewName(review.getReviewName());
        reviewDTO.setReviewContent(review.getReviewContent());
        reviewDTO.setReviewCreateAt(review.getReviewCreateAt());
        reviewDTO.setReviewHit(review.getReviewHit());
        reviewDTO.setSavedFileName(review.getSavedFileName());
        reviewDTO.setOriginFileName(review.getOriginFileName());

        return reviewDTO;
    }

    public void update(String reviewName, String reviewTitle, String reviewContent, String reviewPassword){
        this.reviewName= reviewName;
        this.reviewTitle= reviewTitle;
        this.reviewContent= reviewContent;

        if(reviewPassword != null && !reviewPassword.isBlank()){
            this.reviewPassword= reviewPassword;
        }
    }
}