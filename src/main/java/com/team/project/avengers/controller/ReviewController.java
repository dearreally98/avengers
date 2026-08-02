package com.team.project.avengers.controller;

import com.team.project.avengers.dto.ReviewDTO;
import com.team.project.avengers.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/list")
    public String list(Model model){
        List<ReviewDTO> reviewList =  reviewService.reviewList();
        model.addAttribute("reviewList", reviewList);
        return "avengers/review/list";
    }

    @GetMapping("/write")
    public String writeForm(Model model){
        model.addAttribute("review", new ReviewDTO());
        return "avengers/review/write";
    }

    @PostMapping("/write")
    public String reviewInsert(ReviewDTO reviewDTO){
        reviewService.reviewInsert(reviewDTO);
        return "redirect:/review/list";
    }

    @GetMapping("/{reviewNo}")
    public String reviewDetail(@PathVariable Long reviewNo, Model model){
        ReviewDTO reviewDTO= reviewService.reviewDetail(reviewNo);
        model.addAttribute("review", reviewDTO);
        return "avengers/review/detail";
    }

    @GetMapping("/{reviewNo}/update")
    public String updateReviewForm(@PathVariable Long reviewNo, Model model){
        ReviewDTO reviewDTO= reviewService.updateReviewForm(reviewNo);
        model.addAttribute("review", reviewDTO);
        return "avengers/review/update";
    }

    @PostMapping("/{reviewNo}/update")
    public String reviewUpdate(@PathVariable Long reviewNo, ReviewDTO reviewDTO){
        reviewService.reviewUpdate(reviewNo, reviewDTO);
        return "redirect:/review/" + reviewNo;
    }

    @PostMapping("/{reviewNo}/password-check")
    @ResponseBody
    public boolean passwordCheck(
            @PathVariable Long reviewNo,
            @RequestParam String reviewPassword){

        return reviewService.passwordCheck(reviewNo, reviewPassword);
    }

    @PostMapping("/{reviewNo}/delete")
    public String reviewDelete(@PathVariable Long reviewNo){
        reviewService.reviewDelete(reviewNo);
        return "redirect:/review/list";
    }
}
