package dev.mission.exec;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;

/**
 * 
 * @author helvin affiche la console les missions qui débutent aujourd’hui ou à
 *         une date ultérieure.
 */
@Controller
@Profile("listerDate")
public class ListerProchainesMissions implements Runnable {

	private MissionRepository missionRepository;

	public ListerProchainesMissions(MissionRepository missionRepository) {
		super();
		this.missionRepository = missionRepository;
	}

	@Override
	public void run() {

		List<Mission> list = missionRepository.missionToday(LocalDate.now());

		System.out.println("Les missions qui débutent à partir d'aujourd’hui Sont : ");
		for (Mission m : list) {
			System.out.println(m);
		}

	}

}
