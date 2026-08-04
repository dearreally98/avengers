package com.team.project.avengers.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "review_comment")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 15, nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String commentBody;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDate createdDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_no", nullable = false)
    private Review review;

    public ReviewComment(String nickname, String commentBody, Review review) {
        this.nickname = nickname;
        this.commentBody = commentBody;
        this.review = review;
    }

    public void update(String nickname, String commentBody) {
        this.nickname = nickname;
        this.commentBody = commentBody;
    }
}
