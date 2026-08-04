package com.team.project.avengers.service;

import com.team.project.avengers.dto.MemorableLinesDTO;

import java.util.List;

public interface MemorableService {
    List<MemorableLinesDTO> memorableLinesList();

    void MemorableLinesInsert(MemorableLinesDTO memorableLinesDTO);

    void MemorableDelete(Long no);

//    void MemorableUpdate()
}
