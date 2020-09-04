package dev.mission.exec;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;

@Controller
@Profile("listerTaux")
public class ListerProchainesMissionsParTJM implements Runnable {

	// affiche dans la console les missions qui débutent aujourd’hui ou à une date
	// ultérieure ET qui ont un taux journalier supérieur ou égal à un taux donné.
	private MissionRepository missionRepository;

	public ListerProchainesMissionsParTJM(MissionRepository missionRepository) {
		super();
		this.missionRepository = missionRepository;
	}

	@Override
	public void run() {
		BigDecimal taux = new BigDecimal(102.00);
		List<Mission> list = missionRepository.missionTaux(LocalDate.now(), taux);

		System.out.println(
				"Les missions qui débutent à partir d'aujourd’hui  avec un taux superieur à : " + taux + " Sont : ");
		for (Mission m : list) {
			System.out.println(m);
		}

	}
}
