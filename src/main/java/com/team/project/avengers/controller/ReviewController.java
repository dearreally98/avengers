package com.team.project.avengers.controller;

import com.team.project.avengers.dto.ReviewDTO;
import com.team.project.avengers.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
