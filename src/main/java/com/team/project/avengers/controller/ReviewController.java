package com.team.project.avengers.controller;

import com.team.project.avengers.common.dto.PageRequestDTO;
import com.team.project.avengers.common.dto.PageResponseDTO;
import com.team.project.avengers.dto.ReviewDTO;
import com.team.project.avengers.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public String list(
            @RequestParam(required = false) String searchType,
            @RequestParam(required = false) String keyword,
            @PageableDefault(
                    size = 10,
                    sort = "reviewNo",
                    direction = Sort.Direction.DESC
            )
            Pageable pageable,
            Model model){

        Page<ReviewDTO> reviewList;

        if(keyword == null || keyword.isBlank()){
            reviewList = reviewService.reviewList(pageable);
        } else {
            reviewList = reviewService.searchReview(searchType, keyword, pageable);
        }

        PageRequestDTO pageRequestDTO =
                new PageRequestDTO(pageable.getPageNumber() + 1, pageable.getPageSize());

        PageResponseDTO<ReviewDTO> responseDTO =
                new PageResponseDTO<>(
                        reviewList.getContent(),
                        pageRequestDTO,
                        reviewList.getTotalElements()
                );

        model.addAttribute("reviewList", reviewList);
        model.addAttribute("responseDTO", responseDTO);
        model.addAttribute("searchType", searchType);
        model.addAttribute("keyword", keyword);

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
