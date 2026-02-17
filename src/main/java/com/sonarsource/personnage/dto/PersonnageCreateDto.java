package com.sonarsource.personnage.dto;

/**
 * DTO pour la création d'un personnage.
 * Pas de validation des stats (6, 8, 10, 12) côté backend (faille volontaire).
 */
public class PersonnageCreateDto {

    private String nom;
    private String race;
    private StatsDto stats;
    private String background;

    public PersonnageCreateDto() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public StatsDto getStats() {
        return stats;
    }

    public void setStats(StatsDto stats) {
        this.stats = stats;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
