package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface WhiskyRepositoryCustom {

    List<Whisky> getWhiskiesFromYear(int year);

    List<Whisky> getWhiskiesFromDistilleryByAge(String distillery, int age);

    List<Whisky> getWhiskiesFromRegion(String region);
}
