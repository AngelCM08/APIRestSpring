package com.example.lastdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonajeService {
    @Autowired
    PersonajeDAO repository;

    public List<Personaje> findAll() {
        return repository.findAll();
    }

    public Personaje getPersonajeById(Integer id) {
        Optional<Personaje> optionalPersonaje;
        optionalPersonaje = repository.findById(id);
        return optionalPersonaje.orElse(null);
    }

    public Personaje newPersonaje(Personaje personaje){
        return repository.save(personaje);
    }

    public void deletePersonaje(Integer id) {
        repository.deleteById(id);
    }

    public Personaje replacePersonaje(Integer id, PersonajeDto personajeDto) {
        repository.deleteById(id);
        Personaje personaje = new Personaje(personajeDto);
        repository.save(personaje);
        return personaje;
    }

    public void updatePersonaje(Personaje personajePatched) {
        repository.save(personajePatched);
    }
}
