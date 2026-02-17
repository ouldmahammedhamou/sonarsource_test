package com.sonarsource.personnage.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personnage")
public class Personnage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String race;

    @Column(name = "stat_int", nullable = false)
    private Integer statInt;

    @Column(name = "stat_str", nullable = false)
    private Integer statStr;

    @Column(name = "stat_dex", nullable = false)
    private Integer statDex;

    @Column(name = "stat_will", nullable = false)
    private Integer statWill;

    @Column(columnDefinition = "TEXT")
    private String background;

    public Personnage() {
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

    public Integer getStatInt() {
        return statInt;
    }

    public void setStatInt(Integer statInt) {
        this.statInt = statInt;
    }

    public Integer getStatStr() {
        return statStr;
    }

    public void setStatStr(Integer statStr) {
        this.statStr = statStr;
    }

    public Integer getStatDex() {
        return statDex;
    }

    public void setStatDex(Integer statDex) {
        this.statDex = statDex;
    }

    public Integer getStatWill() {
        return statWill;
    }

    public void setStatWill(Integer statWill) {
        this.statWill = statWill;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
