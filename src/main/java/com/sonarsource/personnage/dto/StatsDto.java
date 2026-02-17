package com.sonarsource.personnage.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Stats du personnage : INT, STR, DEX, WILL.
 * Valeurs autorisées côté métier : 6, 8, 10, 12 (vérification optionnelle côté backend).
 */
public class StatsDto {

    @JsonProperty("INT")
    private int INT;
    @JsonProperty("STR")
    private int STR;
    @JsonProperty("DEX")
    private int DEX;
    @JsonProperty("WILL")
    private int WILL;

    public StatsDto() {
    }

    public StatsDto(int INT, int STR, int DEX, int WILL) {
        this.INT = INT;
        this.STR = STR;
        this.DEX = DEX;
        this.WILL = WILL;
    }

    public int getINT() {
        return INT;
    }

    public void setINT(int INT) {
        this.INT = INT;
    }

    public int getSTR() {
        return STR;
    }

    public void setSTR(int STR) {
        this.STR = STR;
    }

    public int getDEX() {
        return DEX;
    }

    public void setDEX(int DEX) {
        this.DEX = DEX;
    }

    public int getWILL() {
        return WILL;
    }

    public void setWILL(int WILL) {
        this.WILL = WILL;
    }
}
