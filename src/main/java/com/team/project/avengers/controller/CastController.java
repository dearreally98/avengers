package com.team.project.avengers.controller;

import com.team.project.avengers.dto.CastResponseDTO;
import com.team.project.avengers.service.CastService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/avengers/cast")
public class CastController {

    private final CastService castService;

    @GetMapping
    public String castList(
            @RequestParam(required = false) String keyword,
            Model model
    ) {
        // 전체 목록 또는 검색 결과 조회
        List<CastResponseDTO> castList =
                castService.findCastList(keyword);

        // 조회 결과를 출연진과 제작진으로 분리
        List<CastResponseDTO> actorList =
                castService.findActorList(castList);

        List<CastResponseDTO> crewList =
                castService.findCrewList(castList);

        // HTML에 데이터 전달
        model.addAttribute("actorList", actorList);
        model.addAttribute("crewList", crewList);
        model.addAttribute("keyword", keyword);

        return "avengers/cast";
    }
}