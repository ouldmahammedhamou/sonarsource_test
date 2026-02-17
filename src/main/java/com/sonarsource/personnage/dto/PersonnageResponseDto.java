package com.sonarsource.personnage.dto;

/**
 * DTO renvoyé par l'API (liste et détail).
 */
public class PersonnageResponseDto {

    private Integer id;
    private String nom;
    private String race;
    private StatsDto stats;
    private String background;

    public PersonnageResponseDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
