package com.team.project.avengers.dto;

import com.team.project.avengers.entity.Cast;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CastResponseDTO {

    private Long castId;
    private String castName;
    private String roleName;
    private String castType;
    private String imagePath;
    private Integer displayOrder;

    public CastResponseDTO(Cast cast) {
        this.castId = cast.getCastId();
        this.castName = cast.getCastName();
        this.roleName = cast.getRoleName();
        this.castType = cast.getCastType();
        this.imagePath = cast.getImagePath();
        this.displayOrder = cast.getDisplayOrder();
    }
}