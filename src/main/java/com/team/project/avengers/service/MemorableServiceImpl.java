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
    public List<MemorableLinesDTO> searchMemorableList(String keyword) {
        List<MemorableLines> memorableList = memorableLinesRepository.findByTitleContainingOrCharacterActorNameContainingOrderByMemoNoDesc(keyword, keyword);
        return memorableList.stream().map(MemorableLinesDTO::fromEntity).toList();
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

    @Override
    @Transactional
    public void MemorableUpdate(Long no, MemorableLinesDTO memorableLinesDTO) {
        MemorableLines memorableLines = memorableLinesRepository.findById(no).orElseThrow(() -> new IllegalArgumentException("해당 데이터가 존재하지 않습니다."));

        memorableLines.update(memorableLinesDTO.getTitleDTO(), memorableLinesDTO.getContentDTO(), memorableLinesDTO.getCharacterActorNameDTO());
    }


}
