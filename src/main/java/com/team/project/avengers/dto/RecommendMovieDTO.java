package com.team.project.avengers.dto;

import com.team.project.avengers.entity.RecommendMovie;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RecommendMovieDTO {
    private Long movieNo; //영화 제목
    private String movieName; //영화이름
    private String movieCast; //여기에 감독이름
    private String movieContent; // 이건 디테일에서 쓸 영화 소개

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate; // 영화 개봉일

    private MultipartFile uploadFile;
    private String saveFilename;
    private String originFilename;

    // DTO -> Entity
    public RecommendMovie toEntity() {
        return new RecommendMovie(
                movieName,
                movieCast,
                movieContent,
                releaseDate,
                saveFilename,
                originFilename);

    }

    // Entity -> DTO
    public static RecommendMovieDTO fromEntity(RecommendMovie recommendMovie) {
        return RecommendMovieDTO.builder()
                .movieNo(recommendMovie.getMovieNo())
                .movieName(recommendMovie.getMovieName())
                .movieCast(recommendMovie.getMovieCast())
                .releaseDate(recommendMovie.getReleaseDate())
                .movieContent(recommendMovie.getMovieContent())
                .saveFilename(recommendMovie.getSaveFilename())
                .originFilename(recommendMovie.getOriginFilename())
                .build();
    }
}
