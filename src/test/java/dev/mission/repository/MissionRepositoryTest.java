package dev.mission.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import dev.mission.entite.Mission;

@DataJpaTest
class MissionRepositoryTest {

	@Autowired
	TestEntityManager entityManager;

	@Autowired
	MissionRepository missionRepository;

	@BeforeEach
	public void setUp() {
		Mission mission = new Mission();
		mission.setLibelle("Mission 1");
		mission.setTauxJournalier(new BigDecimal("100.90"));
		mission.setDateDebut(LocalDate.now());
		mission.setDateFin(LocalDate.of(2021, 3, 4));

		entityManager.persist(mission);

	}

	@Test
	void findByDateDebutGreaterThanEqual() {
		List<Mission> list = missionRepository.findByDateDebutGreaterThanEqual(LocalDate.now());
		assertThat(list).extracting(Mission::getLibelle).contains("Mission 1");

	}

	@Test
	void findByDateDebutGreaterThanEqualAndTauxJournalierGreaterThanEqual() {

		List<Mission> list = missionRepository.findByDateDebutGreaterThanEqualAndTauxJournalierGreaterThanEqual(
				LocalDate.now(), new BigDecimal(100.00));
		assertThat(list).extracting(Mission::getLibelle).contains("Mission 1");
	}

}
