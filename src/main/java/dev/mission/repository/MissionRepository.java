package dev.mission.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.mission.entite.Mission;

public interface MissionRepository extends JpaRepository<Mission, Integer> {

	// @Query("select m from Mission m where m.dateDebut >= ?1")
	List<Mission> findByDateDebutGreaterThanEqual(Object localDate);

	// @Query("select m from Mission m where m.dateDebut >= ?1 and m.tauxJournalier
	// >= ?2")
	List<Mission> findByDateDebutGreaterThanEqualAndTauxJournalierGreaterThanEqual(LocalDate now, BigDecimal taux);

}
