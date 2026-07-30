package com.team.project.avengers.service;

import com.team.project.avengers.common.dto.PageRequestDTO;
import com.team.project.avengers.common.dto.PageResponseDTO;
import com.team.project.avengers.dto.RecommendMovieDTO;
import com.team.project.avengers.entity.RecommendMovie;
import com.team.project.avengers.repository.RecommendMovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RecommendMovieServiceImpl implements RecommendMovieService {

    private final RecommendMovieRepository recommendMovieRepository;

    @Override
    public PageResponseDTO<RecommendMovieDTO> getRecommendMovieList(PageRequestDTO pageRequestDTO) {
        Pageable pageable = pageRequestDTO.getPageable("movieNo");

        Page<RecommendMovie> result = recommendMovieRepository.searchMovies(
                pageRequestDTO.getSearchType(),
                pageRequestDTO.getKeyword(),
                pageable
        );

        List<RecommendMovieDTO> dtoList = result.getContent().stream()
                .map(RecommendMovieDTO::fromEntity)
                .toList();

        return new PageResponseDTO<>(dtoList, pageRequestDTO, result.getTotalElements());
    }

    @Override
    public RecommendMovieDTO getRecommendMovieDetail(Long movieNo) {
        RecommendMovie recommendMovie = recommendMovieRepository.findById(movieNo)
                .orElseThrow(() -> new IllegalArgumentException("해당 영화 추천 정보를 찾을 수 없습니다. movieNo=" + movieNo));

        return RecommendMovieDTO.fromEntity(recommendMovie);
    }
}