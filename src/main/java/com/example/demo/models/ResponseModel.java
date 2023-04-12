package com.example.demo.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseModel {
    private String episode;
    private String episodeName;
    private List<PersonajeResponseModel> character;
    public String getEpisode() {
        return episode;
    }
    public void setEpisode(String episode) {
        this.episode = episode;
    }
    public String getEpisodeName() {
        return episodeName;
    }
    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }
    public List<PersonajeResponseModel> getCharacter() {
        return character;
    }
    public void setCharacter(List<PersonajeResponseModel> character) {
        this.character = character;
    }
}
