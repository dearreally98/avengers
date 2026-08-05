package com.team.project.avengers;

import com.team.project.avengers.entity.Cast;
import com.team.project.avengers.repository.CastRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AvengersApplicationTests {

	@Autowired
	private CastRepository castRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void insertCastDataTest() {

		// 데이터가 존재하면 중복 입력하지 않고 테스트 종료
		if (castRepository.count() > 0) {
			System.out.println("이미 출연진 및 제작진 데이터가 존재합니다.");
			return;
		}

		List<Cast> castList = List.of(
				createCast(
						"로버트 다우니 주니어",
						"토니 스타크 / 아이언맨",
						"ACTOR",
						"/image/cast/robert-downey-jr.jpg",
						1
				),
				createCast(
						"크리스 에반스",
						"스티브 로저스 / 캡틴 아메리카",
						"ACTOR",
						"/image/cast/chris-evans.jpg",
						2
				),
				createCast(
						"마크 러팔로",
						"브루스 배너 / 헐크",
						"ACTOR",
						"/image/cast/mark-ruffalo.jpg",
						3
				),
				createCast(
						"크리스 헴스워스",
						"토르",
						"ACTOR",
						"/image/cast/chris-hemsworth.jpg",
						4
				),
				createCast(
						"스칼렛 요한슨",
						"나타샤 로마노프 / 블랙 위도우",
						"ACTOR",
						"/image/cast/scarlett-johansson.jpg",
						5
				),
				createCast(
						"제레미 레너",
						"클린트 바튼 / 호크아이",
						"ACTOR",
						"/image/cast/jeremy-renner.jpg",
						6
				),
				createCast(
						"조스 웨던",
						"감독 및 각본",
						"CREW",
						"/image/cast/joss-whedon.jpg",
						7
				),
				createCast(
						"케빈 파이기",
						"제작",
						"CREW",
						"/image/cast/kevin-feige.jpg",
						8
				),
				createCast(
						"앨런 실베스트리",
						"음악",
						"CREW",
						"/image/cast/alan-silvestri.jpg",
						9
				),
				createCast(
						"시머스 맥가비",
						"촬영",
						"CREW",
						"/image/cast/default-profile.jpg",
						10
				)
		);

		castRepository.saveAllAndFlush(castList);

		assertEquals(10, castRepository.count());

		castRepository
				.findAllByOrderByDisplayOrderAsc()
				.forEach(this::printCast);
	}

	private Cast createCast(
			String castName,
			String roleName,
			String castType,
			String imagePath,
			Integer displayOrder
	) {
		Cast cast = new Cast();

		cast.setCastName(castName);
		cast.setRoleName(roleName);
		cast.setCastType(castType);
		cast.setImagePath(imagePath);
		cast.setDisplayOrder(displayOrder);

		return cast;
	}

	private void printCast(Cast cast) {
		System.out.println("--------------------------------");
		System.out.println("번호: " + cast.getCastId());
		System.out.println("이름: " + cast.getCastName());
		System.out.println("배역/직무: " + cast.getRoleName());
		System.out.println("구분: " + cast.getCastType());
		System.out.println("이미지: " + cast.getImagePath());
		System.out.println("출력 순서: " + cast.getDisplayOrder());
	}
}