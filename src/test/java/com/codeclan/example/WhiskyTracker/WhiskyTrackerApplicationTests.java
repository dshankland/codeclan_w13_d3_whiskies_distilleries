package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getWhiskiesFromYear1995() {
		List<Whisky> found = whiskyRepository.getWhiskiesFromYear(1995);
		assertEquals("The Macallan Anniversary Malt", found.get(0).getName());
	}

	@Test
	public void getWhiskiesFromYearJpaMethod2018() {
		List<Whisky> found = whiskyRepository.getWhiskyByYear(2018);
		assertEquals(2, found.size());
	}

	@Test
	public void canGetDistillieriesByRegion() {
		List<Distillery> found = distilleryRepository.getDistilleriesFromRegion("Highland");
		assertEquals(1, found.size());
	}

	@Test
	public void getWhiskiesFromDistilleryByAge() {
		List<Whisky> found = whiskyRepository.getWhiskiesFromDistilleryByAge("Glendronach", 12);
		assertEquals("The Glendronach Original", found.get(0).getName());
	}

	@Test
	public void getWhiskiesFromRegion() {
		List<Whisky> found = whiskyRepository.getWhiskiesFromRegion("Highland");
		assertEquals(2, found.size());
	}

	@Test
	public void getDistilleriesThatHaveWhiskyOfAge() {
		List<Distillery> found = distilleryRepository.getDistilleriesThatHaveWhiskiesOfAge(12);
		assertEquals(2, found.size());
	}
}
