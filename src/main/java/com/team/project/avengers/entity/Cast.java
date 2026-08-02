package com.team.project.avengers.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CAST_INFO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cast {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "castSequenceGenerator"
    )
    @SequenceGenerator(
            name = "castSequenceGenerator",
            sequenceName = "CAST_SEQ",
            allocationSize = 1
    )
    @Column(name = "CAST_ID")
    private Long castId;

    @Column(name = "CAST_NAME", nullable = false, length = 100)
    private String castName;

    @Column(name = "ROLE_NAME", nullable = false, length = 100)
    private String roleName;

    @Column(name = "CAST_TYPE", nullable = false, length = 20)
    private String castType;

    @Column(name = "IMAGE_PATH", nullable = false, length = 500)
    private String imagePath;

    @Column(name = "DISPLAY_ORDER", nullable = false, unique = true)
    private Integer displayOrder;
}