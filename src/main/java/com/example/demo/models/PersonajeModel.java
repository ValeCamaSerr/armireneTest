package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Personaje")
public class PersonajeModel {
    @Id
    @Column(unique = true,nullable = false)
    private Long id;
    private String nombre;
    private String especie;
    private String genero;
    private String imagen;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public Long getIdLugar() {
        return idLugar;
    }
    public void setIdLugar(Long idLugar) {
        this.idLugar = idLugar;
    }
    private Long idLugar;

}
