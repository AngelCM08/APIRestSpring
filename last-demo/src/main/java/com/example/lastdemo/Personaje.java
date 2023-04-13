package com.example.lastdemo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "personaje")
public class Personaje {
    @Id
    @Column(name = "idpersonaje")
    private int id;
    private String icono;
    private String nombre;
    private int vida;
    private String daño;
    private String cadencia;
    private String vel_proyectil;
    private String rango;
    private String velocidad;
    private int suerte;

    public Personaje() {}

    public Personaje(int id, String icono, String nombre, int vida, String daño, String cadencia, String vel_proyectil, String rango, String velocidad, int suerte) {
        this.id = id;
        this.icono = icono;
        this.nombre = nombre;
        this.vida = vida;
        this.daño = daño;
        this.cadencia = cadencia;
        this.vel_proyectil = vel_proyectil;
        this.rango = rango;
        this.velocidad = velocidad;
        this.suerte = suerte;
    }
    
    public Personaje(PersonajeDto personajeDto){
        this.id = personajeDto.getId();
        this.icono = personajeDto.getIcono();
        this.nombre = personajeDto.getNombre();
        this.vida = personajeDto.getVida();
        this.daño = personajeDto.getDaño();
        this.cadencia = personajeDto.getCadencia();
        this.vel_proyectil = personajeDto.getVel_proyectil();
        this.rango = personajeDto.getRango();
        this.velocidad = personajeDto.getVelocidad();
        this.suerte = personajeDto.getSuerte();
    }
}
