package com.team.project.avengers.controller;

import com.team.project.avengers.dto.ReviewCommentDTO;
import com.team.project.avengers.service.ReviewCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReviewCommentController {
    private final ReviewCommentService commentService;

    @GetMapping("/review/{reviewNo}/comments")
    public Page<ReviewCommentDTO> reviewCommentList(
            @PathVariable Long reviewNo,
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC)
            Pageable pageable) {
        return commentService.reviewCommentList(reviewNo, pageable);
    }

    @PostMapping("/review/{reviewNo}/comments")
    public ReviewCommentDTO commentInsert(@PathVariable Long reviewNo, @RequestBody ReviewCommentDTO reviewCommentDTO){
        reviewCommentDTO.setReviewNo(reviewNo);
        return commentService.commentInsert(reviewCommentDTO);
    }

    @PutMapping("/review/comments/{id}")
    public ReviewCommentDTO commentUpdate(
            @PathVariable Long id,
            @RequestBody ReviewCommentDTO commentDTO){
        return commentService.commentUpdate(id, commentDTO);
    }

    @DeleteMapping("/review/comments/{commentNo}")
    public void commentDelete(@PathVariable Long commentNo){
        commentService.commentDelete(commentNo);
    }
}
