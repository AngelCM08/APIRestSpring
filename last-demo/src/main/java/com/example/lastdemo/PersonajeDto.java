package com.example.lastdemo;

import lombok.Data;

@Data
public class PersonajeDto {
    int id;
    String icono;
    String nombre;
    int vida;
    String daño;
    String cadencia;
    String vel_proyectil;
    String rango;
    String velocidad;
    int suerte;

    public PersonajeDto(int id, String icono, String nombre, int vida, String daño, String cadencia, String vel_proyectil, String rango, String velocidad, int suerte) {
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

    public PersonajeDto(Personaje pj) {
        this.id = pj.getId();
        this.icono = pj.getIcono();
        this.nombre = pj.getNombre();
        this.vida = pj.getVida();
        this.daño = pj.getDaño();
        this.cadencia = pj.getCadencia();
        this.vel_proyectil = pj.getVel_proyectil();
        this.rango = pj.getRango();
        this.velocidad = pj.getVelocidad();
        this.suerte = pj.getSuerte();
    }
}
