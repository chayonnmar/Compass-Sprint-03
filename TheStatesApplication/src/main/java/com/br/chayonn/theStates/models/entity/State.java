package com.br.chayonn.theStates.models.entity;

import com.br.chayonn.theStates.models.entity.regiao.Regiao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "states_db")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String regiao;
    private double populacao;
    private String capital;
    private double area;

    public State(){

    }

    public State(long id, String nome, String regiao, double populacao, String capital, double area) {
        this.id = id;
        this.nome = nome;
        this.regiao = Regiao.valueOf(regiao).getRegiao();
        this.populacao = populacao;
        this.capital = capital;
        this.area = area;
    }

    public State(StateDto state){
        this.id = state.getId();
        this.nome = state.getNome();
        this.regiao = Regiao.valueOf(state.getRegiao().toUpperCase()).getRegiao();
        this.populacao = state.getPopulacao();
        this.capital = state.getCapital();
        this.area = state.getArea();
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
