package com.team.project.avengers.service;

import com.team.project.avengers.dto.MemorableLinesDTO;
import com.team.project.avengers.entity.MemorableLines;
import com.team.project.avengers.repository.MemorableLinesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemorableServiceImpl implements MemorableService {
    private final MemorableLinesRepository memorableLinesRepository;

    @Override
    public List<MemorableLinesDTO> memorableList() {
        List<MemorableLines> memorableLinesList = memorableLinesRepository.findAll();

        return memorableLinesList.stream().map(memorableLines -> MemorableLinesDTO.fromEntity(memorableLines)).toList();
    }
}
