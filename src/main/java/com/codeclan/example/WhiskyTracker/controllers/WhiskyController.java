package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/year/{year}")
    public List<Whisky> getWhiskiesFromYear(@PathVariable int year) {
        return whiskyRepository.getWhiskiesFromYear(year);
    }

    @GetMapping(value = "/yearjpa/{year}")
    public List<Whisky> getWhiskiesFromYearJpa(@PathVariable int year) {
        return whiskyRepository.getWhiskyByYear(year);
    }

    @GetMapping(value = "/distilleryandage/{distillery}/{age}")
    public List<Whisky> getWhiskiesFromDistilleryByAge(@PathVariable String distillery, @PathVariable int age) {
        return whiskyRepository.getWhiskiesFromDistilleryByAge(distillery, age);
    }

    @GetMapping(value = "/distilleryregion/{region}")
    public List<Whisky> getWhiskiesFromRegion(@PathVariable String region) {
        return whiskyRepository.getWhiskiesFromRegion(region);
    }

}
