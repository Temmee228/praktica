package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class TournamentModel {

    @Id
    private Long id;
    private String name;
    private String type;
    private String city;

    //private List<String> participatingCities;
    private int ageRestrictions;
    private String classRestriction;
    private String competitionSubject;
    private int teamSize;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
/*
    public List<String> getParticipatingCities() {
        return participatingCities;
    }

    public void setParticipatingCities(List<String> participatingCities) {
        this.participatingCities = participatingCities;
    }*/

    public int getAgeRestrictions() {
        return ageRestrictions;
    }

    public void setAgeRestrictions(int ageRestrictions) {
        this.ageRestrictions = ageRestrictions;
    }

    public String getClassRestriction() {
        return classRestriction;
    }

    public void setClassRestriction(String classRestriction) {
        this.classRestriction = classRestriction;
    }

    public String getCompetitionSubject() {
        return competitionSubject;
    }

    public void setCompetitionSubject(String competitionSubject) {
        this.competitionSubject = competitionSubject;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }


    public TournamentModel() {
    }

    public TournamentModel(Long id, String name, String type, String city, List<String> participatingCities, int ageRestrictions, String classRestriction, String competitionSubject, int teamSize) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.city = city;
       // this.participatingCities = participatingCities;
        this.ageRestrictions = ageRestrictions;
        this.classRestriction = classRestriction;
        this.competitionSubject = competitionSubject;
        this.teamSize = teamSize;
    }
}
