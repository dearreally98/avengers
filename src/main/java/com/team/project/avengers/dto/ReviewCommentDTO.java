package com.team.project.avengers.dto;

import com.team.project.avengers.entity.Review;
import com.team.project.avengers.entity.ReviewComment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewCommentDTO {
    private Long id;
    private String nickname;
    private String commentBody;
    private LocalDate createdDate;

    private Long reviewNo;

    public ReviewComment toEntity(Review review){
        return new ReviewComment(nickname, commentBody, review);
    }

    public static ReviewCommentDTO fromEntity(ReviewComment reviewComment) {
        return new ReviewCommentDTO(reviewComment.getId(), reviewComment.getNickname(),
                                     reviewComment.getCommentBody(), reviewComment.getCreatedDate(),
                                     reviewComment.getReview().getReviewNo());
    }
}