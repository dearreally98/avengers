package com.team.project.avengers;

import com.team.project.avengers.repository.RecommendMovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

@DataJpaTest
@AutoConfigureTestDatabase
@Slf4j
public class RecommendMovieTest {

    @Autowired
    private RecommendMovieRepository recommendMovieRepository;


}
