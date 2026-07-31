package com.team.project.avengers;

import com.team.project.avengers.entity.MemorableLines;
import com.team.project.avengers.repository.MemorableLinesRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Commit;

@DataJpaTest
@Slf4j
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemorableTest {
    @Autowired
    private MemorableLinesRepository memorableLinesRepository;

    private void printMemorable(MemorableLines memorableLines) {
        log.info("게시글 번호: {}", memorableLines.getMemoNo());
        log.info("배우 이름: {}", memorableLines.getActorName());
        log.info("제목: {}", memorableLines.getTitle());
        log.info("내용: {}", memorableLines.getContent());
        log.info("닉네임: {}", memorableLines.getNickname());
        log.info("작성일: {}", memorableLines.getCreateTime());
        log.info("추천수: {}", memorableLines.getGood());
        log.info("비밀번호: {}", memorableLines.getPassword());
    }

    @Test
    @Commit
    public void memorableInsertTest() {
        memorableLinesRepository.save(new MemorableLines("jljl", "아이언맨", "로버트 다우니 주니어",
                "I am Irom man", "마블의 시작...", "2646"));
        memorableLinesRepository.save(new MemorableLines("dsfaf", "캡틴 아메리카", "크리스 에반스",
                "Avengers, assemble", "캬!!!", "1313"));
    }


}
