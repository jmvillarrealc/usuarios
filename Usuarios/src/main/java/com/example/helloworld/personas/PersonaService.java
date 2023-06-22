package com.example.helloworld.personas;

import java.util.List;

public interface PersonaService {
    /**
     * 
     * @return
     */
    List<Persona> getAll();
    
    /**
     * metodo get 001
     * @param id
     * @return
     */
    Persona get(int id);
    
    /**
     * metodo insert 002
     * @param persona
     * @return
     */
    int insert(Persona persona);
    
    /**
     * metodo update 003
     * @param persona
     * @return
     */
    int update(Persona persona);
    
    /**
     * metodo delete 003
     * @param id
     * @return
     */
    int delete(int id);
}

/*
una intefaz de servicio DEBE OBLIGATORIAMENTE  contener javadoc para cada método
presenta métodos cuya implementación usa otros servicios y uno o varios mappers.
*/