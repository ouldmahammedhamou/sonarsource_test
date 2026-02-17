package com.sonarsource.personnage.controller;

import com.sonarsource.personnage.dto.PersonnageCreateDto;
import com.sonarsource.personnage.dto.PersonnageResponseDto;
import com.sonarsource.personnage.service.PersonnageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonnageController {

    private final PersonnageService personnageService;

    public PersonnageController(PersonnageService personnageService) {
        this.personnageService = personnageService;
    }

    /**
     * GET /api/list — remonte tous les personnages.
     */
    @GetMapping("/list")
    public List<PersonnageResponseDto> list() {
        return personnageService.getAll();
    }

    /**
     * GET /api/perso/{id} — détail d'un personnage.
     */
    @GetMapping("/perso/{id}")
    public ResponseEntity<PersonnageResponseDto> getById(@PathVariable int id) {
        PersonnageResponseDto dto = personnageService.getById(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    /**
     * POST /api/create — création d'un nouveau personnage.
     * Pas de validation des stats (6, 8, 10, 12) côté backend.
     */
    @PostMapping("/create")
    public ResponseEntity<PersonnageResponseDto> create(@RequestBody PersonnageCreateDto dto) {
        PersonnageResponseDto created = personnageService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
