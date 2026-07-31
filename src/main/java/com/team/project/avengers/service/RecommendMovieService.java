package com.team.project.avengers.service;

import com.team.project.avengers.common.dto.PageRequestDTO;
import com.team.project.avengers.common.dto.PageResponseDTO;
import com.team.project.avengers.dto.RecommendMovieDTO;

import java.util.List;

public interface RecommendMovieService {
    List<RecommendMovieDTO> movieList();
    PageResponseDTO<RecommendMovieDTO> movieList(PageRequestDTO pageRequestDTO);

    RecommendMovieDTO getRecommendMovieDetail(Long movieNo);
}
