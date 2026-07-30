package com.team.project.avengers.dto;


import com.team.project.avengers.entity.RecommendMovie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@Getter
@Setter
public class RecommendMovieDTO {
    private Long movieNo;
    private String movieName;
    private String movieCast;
    private String postUrl;
    private String movieContent;

    private MultipartFile uploadFile;
    private String savedFilename;
    private String OriginFilename;

    public RecommendMovie toEntity() {
        return new RecommendMovie(movieName, movieCast, postUrl, movieContent);
    }

    public static RecommendMovieDTO fromEntity(RecommendMovie recommendMovie) {
        RecommendMovieDTO recommendMovieDTO = new RecommendMovieDTO();
        recommendMovieDTO.setMovieNo(recommendMovie.getMovieNo());
        recommendMovieDTO.setMovieName(recommendMovieDTO.getMovieName());
        recommendMovieDTO.setMovieCast(recommendMovie.getMovieCast());
        recommendMovieDTO.setPostUrl(recommendMovie.getPostUrl());
        recommendMovieDTO.setMovieContent(recommendMovie.getMovieContent());
        recommendMovieDTO.setSavedFilename(recommendMovie.getSaveFilename());
        recommendMovieDTO.setOriginFilename(recommendMovie.getOriginFilename());

        return recommendMovieDTO;
    }

}
