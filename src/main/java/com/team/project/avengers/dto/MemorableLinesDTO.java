package com.team.project.avengers.dto;

import com.team.project.avengers.entity.MemorableLines;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemorableLinesDTO {
    private Long memorableNo;
    private String memorableActorName;
    private String memorableContent;
    private String memorableCreateTime;
    private int memorableGood;
    private String memorableNickname;
    private String memorablePassword;
    private String memorableTitle;

    public MemorableLines toEntity() {
        return new MemorableLines(memorableNickname, memorableActorName, memorableTitle, memorableContent, memorablePassword);
    }

    public static MemorableLinesDTO fromEntity(MemorableLines memorableLines) {
        MemorableLinesDTO memorableLinesDTO = new MemorableLinesDTO();
        memorableLinesDTO.setMemorableNo(memorableLines.getMemoNo());
        memorableLinesDTO.setMemorableActorName(memorableLines.getActorName());
        memorableLinesDTO.setMemorableNickname(memorableLines.getNickname());

        return memorableLinesDTO;
    }

}
