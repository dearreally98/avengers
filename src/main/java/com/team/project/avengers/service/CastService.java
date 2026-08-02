package com.team.project.avengers.service;

import com.team.project.avengers.dto.CastResponseDTO;
import com.team.project.avengers.entity.Cast;
import com.team.project.avengers.repository.CastRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CastService {

    private final CastRepository castRepository;

    /**
     * 검색어에 따라 전체 목록 또는 검색 결과 조회
     */
    public List<CastResponseDTO> findCastList(String keyword) {

        List<Cast> castList;

        if (keyword == null || keyword.isBlank()) {
            castList =
                    castRepository.findAllByOrderByDisplayOrderAsc();
        } else {
            String trimmedKeyword = keyword.trim();

            castList =
                    castRepository
                            .findByCastNameContainingIgnoreCaseOrRoleNameContainingIgnoreCaseOrderByDisplayOrderAsc(
                                    trimmedKeyword,
                                    trimmedKeyword
                            );
        }

        return castList.stream()
                .map(CastResponseDTO::new)
                .toList();
    }

    /**
     * 전체 조회 결과에서 출연진만 분리
     */
    public List<CastResponseDTO> findActorList(
            List<CastResponseDTO> castList
    ) {
        return castList.stream()
                .filter(cast ->
                        "ACTOR".equals(cast.getCastType()))
                .toList();
    }

    /**
     * 전체 조회 결과에서 제작진만 분리
     */
    public List<CastResponseDTO> findCrewList(
            List<CastResponseDTO> castList
    ) {
        return castList.stream()
                .filter(cast ->
                        "CREW".equals(cast.getCastType()))
                .toList();
    }
}