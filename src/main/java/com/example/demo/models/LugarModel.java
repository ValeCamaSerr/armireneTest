package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Lugar")
public class LugarModel {
    @Id
    @Column(unique = true,nullable = false)
    private Long id;
    private String nombre;
    private String tipo;
    private String dimension;
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
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getDimension() {
        return dimension;
    }
    public void setDimension(String dimension) {
        this.dimension = dimension;
    }
}
