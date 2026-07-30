package com.team.project.avengers.service;

import com.team.project.avengers.common.dto.PageRequestDTO;
import com.team.project.avengers.common.dto.PageResponseDTO;
import com.team.project.avengers.dto.RecommendMovieDTO;

public interface RecommendMovieService {
    PageResponseDTO<RecommendMovieDTO> getRecommendMovieList(PageRequestDTO pageRequestDTO);
    RecommendMovieDTO getRecommendMovieDetail(Long movieNo);
}
