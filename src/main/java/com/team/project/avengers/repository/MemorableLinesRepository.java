package com.team.project.avengers.repository;

import com.team.project.avengers.entity.MemorableLines;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemorableLinesRepository extends JpaRepository<MemorableLines, Long> {
    List<MemorableLines> findByTitleContainingOrCharacterActorNameContainingOrderByMemoNoDesc(String title, String characterActorName);
}
