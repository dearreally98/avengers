package com.team.project.avengers.repository;

import com.team.project.avengers.entity.Cast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CastRepository extends JpaRepository<Cast, Long> {

    // 전체 출연진·제작진을 출력 순서대로 조회
    List<Cast> findAllByOrderByDisplayOrderAsc();

    // 배우 또는 제작진을 구분하여 출력 순서대로 조회
    List<Cast> findByCastTypeOrderByDisplayOrderAsc(String castType);

    // 이름 또는 배역·직무에 검색어가 포함된 인물 조회
    List<Cast>
    findByCastNameContainingIgnoreCaseOrRoleNameContainingIgnoreCaseOrderByDisplayOrderAsc(
            String castName,
            String roleName
    );
}