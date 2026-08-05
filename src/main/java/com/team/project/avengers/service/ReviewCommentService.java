package com.team.project.avengers.service;

import com.team.project.avengers.dto.ReviewCommentDTO;
import com.team.project.avengers.entity.Review;
import com.team.project.avengers.entity.ReviewComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReviewCommentService {
   Page<ReviewCommentDTO> reviewCommentList(Long reviewNo, Pageable pageable);
    ReviewCommentDTO commentInsert(ReviewCommentDTO reviewCommentDTO);
    ReviewCommentDTO commentUpdate(Long id, ReviewCommentDTO commentDTO);
    void commentDelete(Long commentNo);
}
