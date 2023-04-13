package com.example.lastdemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonajeDAO extends JpaRepository<Personaje, Integer> {
    List<Personaje> findAll();
}