package com.example.pirateservice;

import com.example.pirateservice.models.Pirate;
import com.example.pirateservice.models.Raid;
import com.example.pirateservice.models.Ship;
import com.example.pirateservice.repositories.PirateRepository;
import com.example.pirateservice.repositories.RaidRepository;
import com.example.pirateservice.repositories.ShipRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PirateserviceApplicationTests {

	// Dependency injection
	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;


	@Test
	void contextLoads() {
	}

//	@Test
//	public void createPirate() {
//		Pirate pirate = new Pirate("John", "Silver", 30);
//		pirateRepository.save(pirate);
//
//		Pirate blackBeard = new Pirate("Captain", "Blackbeard", 50);
//		pirateRepository.save(blackBeard);
//	}

	@Test
	public void createPirateAndShip() {
		Ship ship = new Ship("The Flying Dutchman");
		shipRepository.save(ship);

		Pirate pirate1 = new Pirate("Jack", "Sparrow", 32, ship);
		pirateRepository.save(pirate1);
	}

	@Test
	public void addPirateAndRaids() {
		Ship ship = new Ship("The Flying Dutchman");
		shipRepository.save(ship);

		Pirate pirate = new Pirate("Jack",  "Sparrow", 32, ship);
		pirateRepository.save(pirate);

		Raid raid1 = new Raid("Totuga", 100);
		raidRepository.save(raid1);

		raid1.addPirate(pirate);
		raidRepository.save(raid1);
	}



}
