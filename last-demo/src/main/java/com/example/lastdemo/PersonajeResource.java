package com.example.lastdemo;

import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(PersonajeResource.PERSONAJES)
public class PersonajeResource {
    public static final String PERSONAJES = "/personajes";
    @Autowired
    PersonajeController personajeController;

    @GetMapping
    public List<PersonajeDto> readAll() {
        return personajeController.getAllPersonajes();
    }

    @GetMapping("{id}")
    public PersonajeDto getPersonaje(@PathVariable Integer id) {
        return personajeController.getPersonajeById(id);
    }

    @GetMapping("{id}/nombre")
    public Map<String, String> nombre(@PathVariable Integer id) {
        return Collections.singletonMap("nombre", personajeController.getPersonajeById(id).nombre);
    }

    @PostMapping
    public PersonajeDto addPersonaje(@RequestBody Personaje personaje){
        return personajeController.addPersonaje(personaje);
    }

    @DeleteMapping("{id}")
    public void deletePersonaje(@PathVariable Integer id){
        personajeController.deletePersonaje(id);
    }

    @PutMapping("{id}")
    public PersonajeDto replace(@PathVariable Integer id, @RequestBody PersonajeDto personajeDto){
        return personajeController.replacePersonaje(id, personajeDto);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json-patch+json")
    public ResponseEntity<Personaje> updatePersonaje(@PathVariable Integer id, @RequestBody JsonPatch patch) {
        return personajeController.updatePersonaje(id, patch);
    }
}