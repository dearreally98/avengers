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

    public List<RecommendMovieDTO> movieList() {
        return recommendMovieRepository.findAll()
                .stream()
                .map(RecommendMovieDTO::fromEntity)
                .toList();
    }

    public PageResponseDTO<RecommendMovieDTO> movieList(PageRequestDTO pageRequestDTO) {
        Pageable pageable = pageRequestDTO.getPageable("movieNo");

//        Page<RecommendMovie> moviePage = recommendMovieRepository.findAll(pageable);
        String searchType = pageRequestDTO.getSearchType();
        String keyword = pageRequestDTO.getKeyword();

        Page<RecommendMovie> moviePage;

        if (keyword == null || keyword.isBlank()) {
            moviePage = recommendMovieRepository.findAll(pageable);
        }else{
            moviePage = switch (searchType == null ? "" : searchType) {
                case "movieName" ->
                        recommendMovieRepository.findByMovieNameContaining(keyword, pageable);
                case "movieCast" ->
                        recommendMovieRepository.findByMovieCastContaining(keyword, pageable);
                default -> recommendMovieRepository.findAll(pageable);
                };
            }


        List<RecommendMovieDTO> dtoList = moviePage.getContent()
                .stream()
                .map(RecommendMovieDTO::fromEntity)
                .toList();

        return new PageResponseDTO<>(dtoList, pageRequestDTO, moviePage.getTotalElements());
    }

    private RecommendMovie getMovie(Long movieNo) {
        return recommendMovieRepository.findById(movieNo)
                .orElseThrow(() -> new IllegalArgumentException(movieNo + "번 게시글이 존재하지 않습니다."));
    }

    @Override
    public RecommendMovieDTO RecommendMovieDetail(Long movieNo) {
        RecommendMovie recommendMovie = getMovie(movieNo);
        return RecommendMovieDTO.fromEntity(recommendMovie);
    }
}