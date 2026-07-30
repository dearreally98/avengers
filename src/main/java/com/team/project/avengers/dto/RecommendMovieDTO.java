package com.team.project.avengers.dto;

import com.team.project.avengers.entity.RecommendMovie;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RecommendMovieDTO {
    private Long movieNo; //영화 제목
    private String movieName; //영화이름
    private String movieCast; //여기에 감독이름
    private String postUrl; // 이미지를 넣을 필드명
    private String movieContent; // 이건 디테일에서 쓸 영화 소개

    private MultipartFile uploadFile;
    private String savedFilename;
    private String originFilename;

    // DTO -> Entity
    public RecommendMovie toEntity() {
        return RecommendMovie.builder()
                .movieNo(this.movieNo)
                .movieName(this.movieName)
                .movieCast(this.movieCast)
                .postUrl(this.postUrl)
                .movieContent(this.movieContent)
                .saveFilename(this.savedFilename)
                .originFilename(this.originFilename)
                .build();
    }

    // Entity -> DTO
    public static RecommendMovieDTO fromEntity(RecommendMovie recommendMovie) {
        return RecommendMovieDTO.builder()
                .movieNo(recommendMovie.getMovieNo())
                .movieName(recommendMovie.getMovieName()) // 오타 수정완료
                .movieCast(recommendMovie.getMovieCast())
                .postUrl(recommendMovie.getPostUrl())
                .movieContent(recommendMovie.getMovieContent())
                .savedFilename(recommendMovie.getSaveFilename())
                .originFilename(recommendMovie.getOriginFilename())
                .build();
    }
}
