package com.team.project.avengers.dto;

import com.team.project.avengers.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private LocalDate reviewCreateAt;
    private int reviewHit;

    public Review toEntity(){
        return new Review(reviewTitle, reviewName, reviewContent, reviewPassword);
    }

    public static ReviewDTO fromEntity(Review review){
        return new ReviewDTO(review.getReviewNo(), review.getReviewTitle(),
                review.getReviewName(), review.getReviewContent(), null,
                review.getReviewCreateAt(), review.getReviewHit());
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