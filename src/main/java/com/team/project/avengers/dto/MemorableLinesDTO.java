package com.team.project.avengers.dto;

import com.team.project.avengers.entity.MemorableLines;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemorableLinesDTO {
    private Long noDTO;
    private String characterActorNameDTO;
    private String contentDTO;
    private LocalDateTime createTimeDTO;
    private int goodDTO;
    private String titleDTO;

    public MemorableLines toEntity() {
        return new MemorableLines(characterActorNameDTO, titleDTO, contentDTO);
    }

    public static MemorableLinesDTO fromEntity(MemorableLines memorableLines) {
        MemorableLinesDTO memorableLinesDTO = new MemorableLinesDTO();
        memorableLinesDTO.setNoDTO(memorableLines.getMemoNo());
        memorableLinesDTO.setCharacterActorNameDTO(memorableLines.getCharacterActorName());
        memorableLinesDTO.setContentDTO(memorableLines.getContent());
        memorableLinesDTO.setCreateTimeDTO(memorableLines.getCreateTime());
        memorableLinesDTO.setGoodDTO(memorableLines.getGood());
        memorableLinesDTO.setTitleDTO(memorableLines.getTitle());

        return memorableLinesDTO;
    }

}
