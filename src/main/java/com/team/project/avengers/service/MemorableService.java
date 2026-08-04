package com.team.project.avengers.service;

import com.team.project.avengers.dto.MemorableLinesDTO;

import java.util.List;

public interface MemorableService {
    List<MemorableLinesDTO> memorableLinesList();

    List<MemorableLinesDTO> searchMemorableList(String keyword);

    void MemorableLinesInsert(MemorableLinesDTO memorableLinesDTO);

    void MemorableDelete(Long no);

    void MemorableUpdate(Long no, MemorableLinesDTO memorableLinesDTO);


}
