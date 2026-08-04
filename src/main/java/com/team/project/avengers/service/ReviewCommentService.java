package com.team.project.avengers.service;

import com.team.project.avengers.dto.ReviewCommentDTO;
import com.team.project.avengers.entity.ReviewComment;

import java.util.List;

public interface ReviewCommentService {
    List<ReviewCommentDTO> reviewCommentList(Long reviewNo);
    ReviewCommentDTO commentInsert(ReviewCommentDTO reviewCommentDTO);
}
