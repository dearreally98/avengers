package com.team.project.avengers.dto;

import com.team.project.avengers.entity.MemorableLines;
import lombok.*;

import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyles.title;

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
        memorableLinesDTO.setMemorableNo();
    }

}
