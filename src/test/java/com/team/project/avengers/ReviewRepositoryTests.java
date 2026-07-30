package com.team.project.avengers;

import com.team.project.avengers.entity.Review;
import com.team.project.avengers.repository.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
public class ReviewRepositoryTests {
    @Autowired
    private ReviewRepository reviewRepository;

    private void print(Review review){
        log.info("리뷰 게시판 번호: {}", review.getReviewNo());
        log.info("제목: {}", review.getReviewTitle());
        log.info("닉네임: {}", review.getReviewName());
        log.info("리뷰 내용: {}", review.getReviewContent());
        log.info("작성일: {}", review.getReviewCreateAt());
        log.info("조회수: {}", review.getReviewHit());
    }

    //게시물 등록 테스트
    @Test
    @Commit
    public void reviewInsertTest(){
        Review review1= new Review(
                "좋은 영화",
                "홍길동",
                "재미있으니까 꼭 보세요",
                "1234"
        );
        Review saveReview1= reviewRepository.save(review1);
        print(saveReview1);

        Review review2= new Review(
                "올 해 반드시 봐야할 최고 명작!!",
                "gg",
                "많은 영웅들이 나오고 감동적이에요! 마블 팬이라면 꼭 봐야할 영화!! 강력 추천",
                "1234"
        );
        Review saveReview2= reviewRepository.save(review2);
        print(saveReview2);

        Review review3= new Review(
                "기대했던 것보다는...",
                "리뷰폭격기",
                "팬이라면 보면 좋겠지만, 그게 아니라면 굳이 볼 필요도 없는 영화. 시간만 버렸네요.",
                "1234"
        );
        Review saveReview3= reviewRepository.save(review3);
        print(saveReview3);
    }
}
