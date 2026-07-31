package com.team.project.avengers.controller;

import com.team.project.avengers.common.dto.PageRequestDTO;
import com.team.project.avengers.common.dto.PageResponseDTO;
import com.team.project.avengers.dto.RecommendMovieDTO;
import com.team.project.avengers.service.RecommendMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/avengers")
@RequiredArgsConstructor
public class RecommendMovieController {

    private final RecommendMovieService recommendMovieService;

    // 1. 추천 영화 목록 조회 (templates/avengers/recommendList.html)
    @GetMapping("/recommendlist")
    public String movieList(PageRequestDTO pageRequestDTO, Model model) {
        PageResponseDTO<RecommendMovieDTO> pageResponseDTO = recommendMovieService.movieList(pageRequestDTO);
        model.addAttribute("pageResponse", pageResponseDTO);
        return "avengers/recommendList";
    }

    // 2. 추천 영화 상세 조회 (templates/avengers/recommendDetail.html)
    @GetMapping("/recommendDetail/{movieNo}")
    public String recommendDetail(@PathVariable("movieNo") Long movieNo, PageRequestDTO pageRequestDTO, Model model) {
        RecommendMovieDTO movieDTO = recommendMovieService.RecommendMovieDetail(movieNo);
        model.addAttribute("movie", movieDTO);
        model.addAttribute("pageRequestDTO", pageRequestDTO);
        return "avengers/recommendDetail";
    }
}
