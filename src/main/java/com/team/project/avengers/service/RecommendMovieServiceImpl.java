package com.team.project.avengers.service;

import com.team.project.avengers.common.dto.PageResponseDTO;
import com.team.project.avengers.dto.RecommendMovieDTO;
import com.team.project.avengers.repository.RecommendMovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RecommendMovieServiceImpl implements RecommendMovieService {
    private final RecommendMovieRepository recommendMovieRepository

    public List<RecommendMovieDTO> movieList() {
        return recommendMovieRepository.findAll()
                .stream()
                .map(RecommendMovieDTO::fromEntity)
                .toList();
    }

    public PageResponseDTO<RecommendMovieDTO> movieList()
}