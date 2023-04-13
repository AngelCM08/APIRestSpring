package com.example.lastdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PersonajeController {
    @Autowired
    PersonajeService personajeService;

    public List<PersonajeDto> getAllPersonajes() {
        List<Personaje> personajeList = personajeService.findAll();
        List<PersonajeDto> personajeDtoList = personajeList.stream().map(PersonajeDto::new).toList();
        return personajeDtoList;
    }

    public PersonajeDto getPersonajeById(Integer id) {
        Personaje personaje = personajeService.getPersonajeById(id);
        return new PersonajeDto(personaje);
    }

    public Personaje addPersonaje(Personaje personaje) {
        return personajeService.newPersonaje(personaje);
    }

    public void deletePersonaje(Integer id) {
        personajeService.deletePersonaje(id);
    }

    public PersonajeDto replacePersonaje(Integer id, PersonajeDto personajeDto) {
        return new PersonajeDto(personajeService.replacePersonaje(id, personajeDto));
    }
}
