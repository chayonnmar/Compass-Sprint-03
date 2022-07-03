package com.br.chayonn.theStates.models.entity.regiao;

public enum Regiao {
    NORTE("Norte"),
    NORDESTE("Nordeste"),
    CENTROOESTE("Centro-Oeste"),
    SUDESTE("Sudeste"),
    SUL("Sul");

    private String regiao;

    Regiao(String name){
        this.regiao = name;
    }

    public String getRegiao() {
        return regiao;
    }
}
