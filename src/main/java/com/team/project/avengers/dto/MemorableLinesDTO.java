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
    private String actorNameDTO;
    private String contentDTO;
    private LocalDateTime createTimeDTO;
    private int goodDTO;
    private String nicknameDTO;
    private String passwordDTO;
    private String titleDTO;

    public MemorableLines toEntity() {
        return new MemorableLines(nicknameDTO, actorNameDTO, titleDTO, contentDTO, passwordDTO);
    }

    public static MemorableLinesDTO fromEntity(MemorableLines memorableLines) {
        MemorableLinesDTO memorableLinesDTO = new MemorableLinesDTO();
        memorableLinesDTO.setNoDTO(memorableLines.getMemoNo());
        memorableLinesDTO.setActorNameDTO(memorableLines.getActorName());
        memorableLinesDTO.setNicknameDTO(memorableLines.getNickname());
        memorableLinesDTO.setContentDTO(memorableLines.getContent());
        memorableLinesDTO.setCreateTimeDTO(memorableLines.getCreateTime());
        memorableLinesDTO.setGoodDTO(memorableLines.getGood());
        memorableLinesDTO.setPasswordDTO(memorableLines.getPassword());
        memorableLinesDTO.setTitleDTO(memorableLines.getTitle());

        return memorableLinesDTO;
    }

}
