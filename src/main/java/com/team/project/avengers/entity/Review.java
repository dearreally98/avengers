package com.team.project.avengers.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Audited;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Table(name= "review_page")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewNo;

    @Column(length= 50, nullable = false)
    private String reviewTitle;

    @Column(length= 15, nullable = false)
    private String reviewName;

    @Lob
    @Column(nullable = false)
    private String reviewContent;

    @Column(length= 12)
    private String reviewPassword;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDate reviewCreateAt;

    private int reviewHit = 0;

    public Review(String reviewTitle, String reviewName, String reviewContent, String reviewPassword){
        this.reviewTitle= reviewTitle;
        this.reviewName= reviewName;
        this.reviewContent= reviewContent;
        this.reviewPassword= reviewPassword;
    }

    public void reviewUpdate(String reviewTitle, String reviewContent){
        this.reviewTitle= reviewTitle;
        this.reviewContent= reviewContent;
    }

    public void passwordChange(String reviewPassword){
        this.reviewPassword= reviewPassword;
    }

    public void addHit(){
        this.reviewHit++;
    }
}
