package com.example.lastdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PersonajeController {
    @Autowired
    PersonajeService personajeService;
    ObjectMapper objectMapper = new ObjectMapper();

    public List<PersonajeDto> getAllPersonajes() {
        List<Personaje> personajeList = personajeService.findAll();
        List<PersonajeDto> personajeDtoList = personajeList.stream().map(PersonajeDto::new).toList();
        return personajeDtoList;
    }

    public PersonajeDto getPersonajeById(Integer id) {
        Personaje personaje = personajeService.getPersonajeById(id);
        return new PersonajeDto(personaje);
    }

    public PersonajeDto addPersonaje(Personaje personaje) {
        return new PersonajeDto(personajeService.newPersonaje(personaje));
    }

    public void deletePersonaje(Integer id) {
        personajeService.deletePersonaje(id);
    }

    public PersonajeDto replacePersonaje(Integer id, PersonajeDto personajeDto) {
        return new PersonajeDto(personajeService.replacePersonaje(id, personajeDto));
    }

    public ResponseEntity<Personaje> updatePersonaje(Integer id, JsonPatch patch) {
        try {
            Personaje personaje = personajeService.getPersonajeById(id);
            Personaje personajePatched = applyPatchToPersonaje(patch, personaje);
            personajeService.updatePersonaje(personajePatched);
            return ResponseEntity.ok(personajePatched);
        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private Personaje applyPatchToPersonaje(JsonPatch patch, Personaje targetPersonaje) throws JsonPatchException, JsonProcessingException {
        JsonNode patched = patch.apply(objectMapper.convertValue(targetPersonaje, JsonNode.class));
        return objectMapper.treeToValue(patched, Personaje.class);
    }
}
