package com.team.project.avengers.controller;

import com.team.project.avengers.dto.ReviewCommentDTO;
import com.team.project.avengers.service.ReviewCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewCommentController {
    private final ReviewCommentService commentService;

    @GetMapping("/review/{reviewNo}/comments")
    public List<ReviewCommentDTO> reviewcommentList(@PathVariable Long reviewNo){
        return commentService.reviewCommentList(reviewNo);
    }

    @PostMapping("/review/{reviewNo}/comments")
    public ReviewCommentDTO commentInsert(@PathVariable Long reviewNo, @RequestBody ReviewCommentDTO reviewCommentDTO){
        reviewCommentDTO.setReviewNo(reviewNo);
        return commentService.commentInsert(reviewCommentDTO);
    }
}
