package com.br.chayonn.theStates.models.entity;


import com.br.chayonn.theStates.models.entity.regiao.Regiao;

public class StateDto {

    private long id;

    private String nome;

    private String regiao;

    private double populacao;

    private String capital;

    private double area;

    public StateDto(){

    }

    public StateDto(long id, String nome, String regiao, double populacao, String capital, double area) {
        this.id = id;
        this.nome = nome;
        this.regiao = Regiao.valueOf(regiao.toUpperCase()).getRegiao();
        this.populacao = populacao;
        this.capital = capital;
        this.area = area;
    }

    public StateDto(State savedStates ){
        this.id = savedStates.getId();
        this.nome = savedStates.getNome();
        this.regiao = savedStates.getRegiao();
        this.populacao = savedStates.getPopulacao();
        this.capital = savedStates.getCapital();
        this.area = savedStates.getArea();
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getRegiao() {
        return regiao;
    }

    public double getPopulacao() {
        return populacao;
    }

    public String getCapital() {
        return capital;
    }

    public double getArea() {
        return area;
    }
}
