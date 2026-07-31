package com.team.project.avengers.controller;

import com.team.project.avengers.dto.MemorableLinesDTO;
import com.team.project.avengers.service.MemorableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/avengers")
public class MemorableLinesController {
    private final MemorableService memorableService;

    @GetMapping("/memorableLinesList")
    public String memorableLinesList(Model model) {
        List<MemorableLinesDTO> memorableLinesList = memorableService.memorableLinesList();
        model.addAttribute("memorableLinesList", memorableLinesList);
        return "/memorableLines/list";
    }
}
