package com.team.project.avengers.controller;

import com.team.project.avengers.dto.MemorableLinesDTO;
import com.team.project.avengers.service.MemorableService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/avengers")
public class MemorableLinesController {
    private final MemorableService memorableService;

    @GetMapping("/memorableList")
    public String memorableList(@RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<MemorableLinesDTO> memorableList = memorableService.memorableList(pageable);
        model.addAttribute("memorableList", memorableList);

        return "/avengers/memorableList";
    }

    @GetMapping("/memorableSearch")
    public String memorableSearch(@RequestParam String keyword, Model model) {

        List<MemorableLinesDTO> memorableList = memorableService.searchMemorableList(keyword);
        model.addAttribute("memorableList", memorableList);

        return "/avengers/memorableList";
    }

    @PostMapping("/memorableList")
    public String memorableLinesInsert(MemorableLinesDTO memorableLinesDTO) {

        memorableService.MemorableLinesInsert(memorableLinesDTO);

        return "redirect:/avengers/memorableList";
    }

    @PostMapping("/memorableDelete")
    public String memorableDelete(@RequestParam Long no) {
        memorableService.MemorableDelete(no);
        return "redirect:/avengers/memorableList";
    }

    @PostMapping("/memorableUpdate")
    public String memorableUpdate(@RequestParam Long no, MemorableLinesDTO memorableLinesDTO) {
        memorableService.MemorableUpdate(no, memorableLinesDTO);
        return "redirect:/avengers/memorableList";
    }
}
