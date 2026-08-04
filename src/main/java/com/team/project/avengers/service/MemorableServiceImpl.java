package com.team.project.avengers.service;

import com.team.project.avengers.dto.MemorableLinesDTO;
import com.team.project.avengers.entity.MemorableLines;
import com.team.project.avengers.repository.MemorableLinesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemorableServiceImpl implements MemorableService {
    private final MemorableLinesRepository memorableLinesRepository;

    @Override
    public List<MemorableLinesDTO> memorableLinesList() {
        List<MemorableLines> memorableLinesList = memorableLinesRepository.findAll(Sort.by(Sort.Direction.DESC, "memoNo"));

        return memorableLinesList.stream().map(memorableLines -> MemorableLinesDTO.fromEntity(memorableLines)).toList();
    }

    @Override
    public void MemorableLinesInsert(MemorableLinesDTO memorableLinesDTO) {
        MemorableLines memorableLines = memorableLinesDTO.toEntity();
        memorableLinesRepository.save(memorableLines);
    }

    @Override
    @Transactional
    public void MemorableDelete(Long no) {
        memorableLinesRepository.deleteById(no);
    }
}
