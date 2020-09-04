package dev.mission.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.mission.entite.Mission;

public interface MissionRepository extends JpaRepository<Mission, Integer> {

	@Query("select m from Mission m where m.dateDebut >= ?1")
	List<Mission> missionToday(Object localDate);

	@Query("select m from Mission m where m.dateDebut >= ?1 and m.tauxJournalier >= ?2")
	List<Mission> missionTaux(LocalDate now, BigDecimal taux);

}
