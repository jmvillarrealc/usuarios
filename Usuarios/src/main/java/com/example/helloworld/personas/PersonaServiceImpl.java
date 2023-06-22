package com.example.helloworld.personas;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class PersonaServiceImpl implements PersonaService {
    private PersonaMapper personaMapper;
    
    public PersonaServiceImpl(PersonaMapper personaMapper) {
        this.personaMapper = personaMapper;
    }
    @Override
    public List<Persona> getAll() {
        return personaMapper.getAll();
    }
	@Override
	public Persona get(int id) {
		return personaMapper.getPersona(id);
	}
	@Override
	public int update(Persona persona) {
	    personaMapper.update(persona);
	    return 0;
	}
	@Override
	public int delete(int id) {
	    personaMapper.delete(id);
	    return  0;
	}
    @Override
    public int insert(Persona persona) {
        // TODO Auto-generated method stub
        personaMapper.insert(persona);
        return 0;
    }
}

/*
las clases de implementacion de servicios generalmente contienen lógica de negocio compleja.
está lógica DEBE OBLIGATORIAMENTE ser probada en su totalidad con pruebas de unidad.


*/