package com.example.helloworld.personas;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class PersonaController {
    private PersonaService personaService;
    
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }
    
    
    @GetMapping(
            value= "/personas/{id}", 
            produces = "application/json; charset=utf-8")
    public Persona personas0(@PathVariable int id) {
        return personaService.get(id);// a ser usado por un método de un servicio qe si me regrese la persona
    }
    @GetMapping(
            value= "/personas", 
            produces = "application/json; charset=utf-8")
    public List<Persona> getAll() {
        return personaService.getAll();
    }
    @PutMapping(
            value= "/personas/{id}", 
            produces = "application/json; charset=utf-8")
    public int update(@RequestBody Persona persona) {
        return personaService.update(persona);
    }
    @PostMapping(
            value= "/personas", 
            produces = "application/json; charset=utf-8")
    public int insert(@RequestBody Persona persona) {
        return personaService.insert(persona);
    }
    @DeleteMapping(
            value= "/personas/{id}", 
            produces = "application/json; charset=utf-8")
    public int delete(@PathVariable int id) {
        return personaService.delete(id);
    }

}
/*
Una clase anotada con @RestController tiene el objetivo de publicar endpoints de tipo REST.
No contiene lógica de negocio
No contiene acceso a DB
SI emplea clases de modelo (como Persona)
Define si el endpoint es de tipo GET / PUT / POST / DELETE
SI indica qué produce (json / xml / text / etc )
IMPORTANTE: define una URL de acceso (que es la unión entre el valor del atributo "value" del endpoint y "value" de RequestMapping)
Lo anterior basado en la corriente de desarrollo llamada DDD 
*/

