package com.team.project.avengers;

import com.team.project.avengers.entity.Cast;
import com.team.project.avengers.repository.CastRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AvengersApplicationTests {

	@Autowired
	private CastRepository castRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void findAllCastTest() {

		List<Cast> castList =
				castRepository.findAllByOrderByDisplayOrderAsc();

		castList.forEach(this::printCast);

		assertEquals(10, castList.size());
	}

	@Test
	void findActorListTest() {

		List<Cast> actorList =
				castRepository
						.findByCastTypeOrderByDisplayOrderAsc("ACTOR");

		actorList.forEach(this::printCast);

		assertEquals(6, actorList.size());

		assertTrue(
				actorList.stream()
						.allMatch(cast ->
								"ACTOR".equals(cast.getCastType()))
		);
	}

	@Test
	void findCrewListTest() {

		List<Cast> crewList =
				castRepository
						.findByCastTypeOrderByDisplayOrderAsc("CREW");

		crewList.forEach(this::printCast);

		assertEquals(4, crewList.size());

		assertTrue(
				crewList.stream()
						.allMatch(cast ->
								"CREW".equals(cast.getCastType()))
		);
	}

	@Test
	void searchByCastNameTest() {

		String keyword = "크리스";

		List<Cast> searchResult =
				castRepository
						.findByCastNameContainingIgnoreCaseOrRoleNameContainingIgnoreCaseOrderByDisplayOrderAsc(
								keyword,
								keyword
						);

		searchResult.forEach(this::printCast);

		assertEquals(2, searchResult.size());
	}

	@Test
	void searchByRoleNameTest() {

		String keyword = "아이언맨";

		List<Cast> searchResult =
				castRepository
						.findByCastNameContainingIgnoreCaseOrRoleNameContainingIgnoreCaseOrderByDisplayOrderAsc(
								keyword,
								keyword
						);

		searchResult.forEach(this::printCast);

		assertFalse(searchResult.isEmpty());

		assertTrue(
				searchResult.stream()
						.anyMatch(cast ->
								cast.getRoleName().contains(keyword))
		);
	}

	@Test
	void emptySearchResultTest() {

		String keyword = "검색되지않는인물";

		List<Cast> searchResult =
				castRepository
						.findByCastNameContainingIgnoreCaseOrRoleNameContainingIgnoreCaseOrderByDisplayOrderAsc(
								keyword,
								keyword
						);

		searchResult.forEach(this::printCast);

		assertTrue(searchResult.isEmpty());
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