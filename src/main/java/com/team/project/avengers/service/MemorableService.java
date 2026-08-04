package com.team.project.avengers.service;

import com.team.project.avengers.dto.MemorableLinesDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemorableService {
    Page<MemorableLinesDTO> memorableList(Pageable pageable);

    List<MemorableLinesDTO> searchMemorableList(String keyword);

    void MemorableLinesInsert(MemorableLinesDTO memorableLinesDTO);

    void MemorableDelete(Long no);

    void MemorableUpdate(Long no, MemorableLinesDTO memorableLinesDTO);


}
