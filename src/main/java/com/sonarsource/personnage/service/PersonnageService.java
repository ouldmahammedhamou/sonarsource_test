package com.sonarsource.personnage.service;

import com.sonarsource.personnage.dto.PersonnageCreateDto;
import com.sonarsource.personnage.dto.PersonnageResponseDto;

import java.util.List;

/**
 * Service métier pour la gestion des personnages.
 */
public interface PersonnageService {

    List<PersonnageResponseDto> getAll();

    PersonnageResponseDto getById(int id);

    PersonnageResponseDto create(PersonnageCreateDto dto);
}
