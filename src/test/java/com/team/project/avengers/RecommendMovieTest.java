package com.team.project.avengers;

import com.team.project.avengers.entity.RecommendMovie;
import com.team.project.avengers.repository.RecommendMovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Commit;

import java.time.LocalDate;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
public class RecommendMovieTest {
    @Autowired
    private RecommendMovieRepository recommendMovieRepository;

    private void printMovie(RecommendMovie recommendMovie) {
        log.info("영화 번호: {}", recommendMovie.getMovieNo());
        log.info("영화 제목: {}", recommendMovie.getMovieName());
        log.info("영화 감독/배우: {}", recommendMovie.getMovieCast());
        log.info("영화 내용: {}", recommendMovie.getMovieContent());
        log.info("영화 개봉일: {}", recommendMovie.getReleaseDate());
        log.info("저장 파일명: {}", recommendMovie.getSaveFilename());
    }

    @Test
    @Commit
    public void movieListInsertTest() {
        RecommendMovie recommendMovie1 = RecommendMovie.builder()
                .movieName("캡틴 아메리카: 시빌 워")
                .movieCast("안소니 루소")
                .movieContent("어벤져스 VS 어벤져스 분열은 시작되었다! 어벤져스와 관련된 사고로 부수적인 피해가 일어나자 정부는 어벤져스를 관리하고 감독하는 시스템인 일명 ‘슈퍼히어로 등록제’를 내놓는다. 어벤져스 내부는 정부의 입장을 지지하는 찬성파(팀 아이언맨)와 이전처럼 정부의 개입 없이 자유롭게 인류를 보호해야 한다는 반대파(팀 캡틴)로 나뉘어 대립하기 시작하는데...")
                .releaseDate(LocalDate.parse("2016-04-27"))
                .saveFilename("캡아 시빌워.jpg")
                .build();


        RecommendMovie saveMovie1 = recommendMovieRepository.save(recommendMovie1);

        printMovie(saveMovie1);

        RecommendMovie recommendMovie2 = RecommendMovie.builder()
                .movieName("토르: 다크월드")
                .movieCast("앨런 테일러")
                .movieContent("<어벤져스>의 뉴욕 사건 후, 다시 신들의 고향인 아스가르드 왕국으로 돌아간 토르(크리스 헴스워스)와 로키(톰 히들스턴). 지구를 위협한 로키는 지하 감옥에 갇히고, 토르는 아버지 오딘(안소니 홉킨스)과 함께 우주의 질서를 재정립하기 위해 나선다. 1년 후, 지구에 혼자 남은 제인(나탈리 포트만)은 우연히 태초부터 존재해왔던 어둠의 종족 ‘다크 엘프’의 무기 ‘에테르’를 얻게 된다. 이 사실을 안 ‘다크 엘프’의 리더 ‘말레키스’는 ‘에테르’를 되찾기 위해 제인과 아스가르드를 공격하고, 토르는 사랑하는 여인 제인과 아스가르드 왕국을 지키기 위해 로키에게 위험한 동맹을 제안하게 된다.")
                .releaseDate(LocalDate.parse("2013-10-30"))
                .saveFilename("토르2.jpg")
                .build();


        RecommendMovie saveMovie2 = recommendMovieRepository.save(recommendMovie2);

        printMovie(saveMovie2);


        RecommendMovie recommendMovie3 = RecommendMovie.builder()
                .movieName("토르: 라그나로크")
                .movieCast("타이카 와이키키")
                .movieContent("죽음의 여신 ‘헬라’가 아스가르드를 침략하고, 세상은 모든 것의 종말 ‘라그나로크’의 위기에 처한다. 헬라에게 자신의 망치마저 파괴당한 토르는 어벤져스 동료인 헐크와도 피할 수 없는 대결을벌이면서 절체절명의 위기에 빠지게 되는데…")
                .releaseDate(LocalDate.parse("2017-10-25"))
                .saveFilename("토르3.jpg")
                .build();


        RecommendMovie saveMovie3 = recommendMovieRepository.save(recommendMovie3);

        printMovie(saveMovie3);

        RecommendMovie recommendMovie4 = RecommendMovie.builder()
                .movieName("가디언즈 오브 갤럭시3")
                .movieCast("제임스 건")
                .movieContent("‘가모라’를 잃고 슬픔에 빠져 있던 ‘피터 퀼’이 위기에 처한 은하계와 동료를 지키기 위해 다시 한번 가디언즈 팀과 힘을 모으고, 성공하지 못할 경우 그들의 마지막이 될지도 모르는 미션에 나서는 이야기")
                .releaseDate(LocalDate.parse("2023-05-03"))
                .saveFilename("가오갤3.jpg")
                .build();


        RecommendMovie saveMovie4 = recommendMovieRepository.save(recommendMovie4);

        printMovie(saveMovie4);


        RecommendMovie recommendMovie5 = RecommendMovie.builder()
                .movieName("닥터 스트레인지: 대혼돈의 멀티버스")
                .movieCast("샘 레이미")
                .movieContent("끝없이 균열되는 차원과 뒤엉킨 시공간의 멀티버스가 열리며 오랜 동료들, 그리고 차원을 넘어 들어온 새로운 존재들을 맞닥뜨리게 된 ‘닥터 스트레인지’. 대혼돈 속, 그는 예상치 못한 극한의 적과 맞서 싸워야만 하는데….")
                .releaseDate(LocalDate.parse("2022-05-04"))
                .saveFilename("닥스2.jpg")
                .build();


        RecommendMovie saveMovie5 = recommendMovieRepository.save(recommendMovie5);

        printMovie(saveMovie5);


        RecommendMovie recommendMovie6 = RecommendMovie.builder()
                .movieName("스파이더맨: 파 프롬 홈")
                .movieCast("존 왓츠")
                .movieContent("‘엔드게임’ 이후 변화된 세상, 스파이더맨 ‘피터 파커’는 학교 친구들과 유럽 여행을 떠나게 된다. 그런 그의 앞에 ‘닉 퓨리’가 등장해 도움을 요청하고 정체불명의 조력자 ‘미스테리오’까지 합류하게 되면서 전 세계를 위협하는 새로운 빌런 ‘엘리멘탈 크리쳐스’와 맞서야만 하는 상황에 놓이게 되는데…")
                .releaseDate(LocalDate.parse("2019-07-02"))
                .saveFilename("스파이더맨 파 프롬 홈.jpg")
                .build();


        RecommendMovie saveMovie6 = recommendMovieRepository.save(recommendMovie6);

        printMovie(saveMovie6);


        RecommendMovie recommendMovie7 = RecommendMovie.builder()
                .movieName("스파이더맨: 홈커밍")
                .movieCast("존 왓츠")
                .movieContent("‘시빌 워’ 당시 ‘토니 스타크’(로버트 다우니 주니어)에게 발탁되어 대단한 활약을 펼쳤던 스파이더맨 ‘피터 파커’(톰 홀랜드). 그에게 새로운 수트를 선물한 ‘토니 스타크’는 위험한 일은 하지 말라며 조언한다. 하지만 허세와 정의감으로 똘똘 뭉친 ‘피터 파커’는 세상을 위협하는 강력한 적 ‘벌처’(마이클 키튼)에 맞서려 하는데… 아직은 어벤져스가 될 수 없는 스파이더맨 숙제보다 세상을 구하고 싶은 스파이더맨 그는 과연 진정한 히어로로 거듭날 수 있을 것인가!")
                .releaseDate(LocalDate.parse("2017-07-05"))
                .saveFilename("스파이더맨 홈 커밍.jpg")
                .build();


        RecommendMovie saveMovie7 = recommendMovieRepository.save(recommendMovie7);

        printMovie(saveMovie7);


        RecommendMovie recommendMovie8 = RecommendMovie.builder()
                .movieName("썬더볼츠")
                .movieCast("제이크 슈레이어")
                .movieContent("초능력 없음, 히어로 없음, 포기도 없음! 마블 역사를 새로 쓸 별난 놈들의 예측불가 팀업이 폭발한다! 어벤져스가 사라진 세상, CIA 국장 '발렌티나'는 새로운 팀을 꾸릴 계획을 세운다. 그녀가 설계한 위험한 함정에 빠진 '옐레나', '윈터 솔져', '레드 가디언', '존 워커', '고스트', '태스크 마스터' 별난 놈들만 모인 이들은 어쩔 수 없이 한 팀이 되고, 자신들의 어두운 과거와 맞서야 하는 위험한 임무에 투입된다. 서로를 전혀 믿지 못하는 상황에서 스스로의 생존과 세상의 구원을 위해 이들은 진정한 팀으로 거듭나야만 하는데....")
                .releaseDate(LocalDate.parse("2025-04-30"))
                .saveFilename("썬더볼츠.jpg")
                .build();


        RecommendMovie saveMovie8 = recommendMovieRepository.save(recommendMovie8);

        printMovie(saveMovie8);


        RecommendMovie recommendMovie9 = RecommendMovie.builder()
                .movieName("아이언맨3")
                .movieCast("셰인 블랙")
                .movieContent("<어벤져스> 뉴욕 사건의 트라우마로 인해 영웅으로서의 삶에 회의를 느끼는 토니 스타크(로버트 다우니 주니어). 그가 혼란을 겪는 사이 최악의 테러리스트 만다린(벤 킹슬리)을 내세운 익스트리미스 집단 AIM이 스타크 저택에 공격을 퍼붓는다. 이 공격으로 그에게 남은 건 망가진 수트 한벌 뿐. 모든 것을 잃어버린 그는 다시 테러의 위험으로부터 세계와 사랑하는 여인(기네스 팰트로)를 지켜내야 하는 동시에 머릿속을 떠나지 않던 한가지 물음의 해답도 찾아야만 한다. 과연 그가 아이언맨인가? 수트가 아이언맨인가?")
                .releaseDate(LocalDate.parse("2013-04-25"))
                .saveFilename("아이언맨3.jpg")
                .build();


        RecommendMovie saveMovie9 = recommendMovieRepository.save(recommendMovie9);

        printMovie(saveMovie9);


        RecommendMovie recommendMovie10 = RecommendMovie.builder()
                .movieName("앤트맨1")
                .movieCast("페이튼 리드")
                .movieContent("하나뿐인 딸에게 멋진 아빠이고 싶지만, 현실은 생계형 도둑인 스캇 랭(폴 러드). 어느 날 그에게 몸을 자유자재로 늘리거나 줄일 수 있는 핌 입자를 개발한 과학자 행크 핌(마이클 더글라스)이 찾아와 수트와 헬멧을 건네며 ‘앤트맨’이 되어 줄 것을 요청한다. 어리둥절 하지만 일단 한번 해보기로 결심한 스캇 랭은 행크 핌의 딸인 호프(에반젤린 릴리)의 도움을 받아 점차 히어로의 면모를 갖추어가고, 그의 스승이자 멘토인 행크 핌 박사를 도와 핌 입자를 악용하려는 세력을 막아야 하는데… 마블 유니버스의 새로운 세계가 이제 그의 손에 달렸다!")
                .releaseDate(LocalDate.parse("2015-09-03"))
                .saveFilename("앤트맨.jpg")
                .build();


        RecommendMovie saveMovie10 = recommendMovieRepository.save(recommendMovie10);

        printMovie(saveMovie10);


        RecommendMovie recommendMovie11 = RecommendMovie.builder()
                .movieName("어벤져스: 엔드게임")
                .movieCast("안소니 루소/조 루소")
                .movieContent("인피니티 워 이후 절반만 살아남은 지구 마지막 희망이 된 어벤져스 먼저 떠난 그들을 위해 모든 것을 걸었다! 위대한 어벤져스 운명을 바꿀 최후의 전쟁이 펼쳐진다!")
                .releaseDate(LocalDate.parse("2019-04-24"))
                .saveFilename("어벤져스엔드게임.jpg")
                .build();


        RecommendMovie saveMovie11 = recommendMovieRepository.save(recommendMovie11);

        printMovie(saveMovie11);


        RecommendMovie recommendMovie12 = RecommendMovie.builder()
                .movieName("어벤져스: 인피니티 워")
                .movieCast("안소니 루소/조 루소")
                .movieContent("새로운 조합을 이룬 어벤져스, 역대 최강 빌런 타노스에 맞서 세계의 운명이 걸린 인피니티 스톤을 향한 무한 대결이 펼쳐진다! 마블의 클라이맥스를 목격하라!")
                .releaseDate(LocalDate.parse("2018-04-25"))
                .saveFilename("어벤져스인피니티워.jpg")
                .build();


        RecommendMovie saveMovie12 = recommendMovieRepository.save(recommendMovie12);

        printMovie(saveMovie12);
    }


}
