package org.example.service;

import org.example.entity.University;

public interface UniversityService {
    public University[] getAllUniversityByCountry(String countryNames);

    public University[] getAllUniversity();
}

