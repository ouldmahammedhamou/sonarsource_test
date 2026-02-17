package com.sonarsource.personnage.service.impl;

import com.sonarsource.personnage.dto.PersonnageCreateDto;
import com.sonarsource.personnage.dto.PersonnageResponseDto;
import com.sonarsource.personnage.dto.StatsDto;
import com.sonarsource.personnage.entity.Personnage;
import com.sonarsource.personnage.repository.PersonnageRepository;
import com.sonarsource.personnage.service.PersonnageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonnageServiceImpl implements PersonnageService {

    private final PersonnageRepository personnageRepository;

    public PersonnageServiceImpl(PersonnageRepository personnageRepository) {
        this.personnageRepository = personnageRepository;
    }

    @Override
    public List<PersonnageResponseDto> getAll() {
        return personnageRepository.findAll().stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public PersonnageResponseDto getById(int id) {
        Optional<Personnage> opt = personnageRepository.findById(id);
        return opt.map(this::toResponseDto).orElse(null);
    }

    @Override
    public PersonnageResponseDto create(PersonnageCreateDto dto) {
        Personnage entity = toEntity(dto);
        entity = personnageRepository.save(entity);
        return toResponseDto(entity);
    }

    private Personnage toEntity(PersonnageCreateDto dto) {
        Personnage p = new Personnage();
        p.setNom(dto.getNom());
        p.setRace(dto.getRace());
        p.setBackground(dto.getBackground());
        if (dto.getStats() != null) {
            p.setStatInt(dto.getStats().getINT());
            p.setStatStr(dto.getStats().getSTR());
            p.setStatDex(dto.getStats().getDEX());
            p.setStatWill(dto.getStats().getWILL());
        }
        return p;
    }

    private PersonnageResponseDto toResponseDto(Personnage entity) {
        PersonnageResponseDto dto = new PersonnageResponseDto();
        dto.setId(entity.getId());
        dto.setNom(entity.getNom());
        dto.setRace(entity.getRace());
        dto.setBackground(entity.getBackground());
        dto.setStats(new StatsDto(
                entity.getStatInt(),
                entity.getStatStr(),
                entity.getStatDex(),
                entity.getStatWill()
        ));
        return dto;
    }
}
