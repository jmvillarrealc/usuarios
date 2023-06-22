package com.example.helloworld.personas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class PersonaMapperOLD {
    private List<Persona> database = null;

    public PersonaMapperOLD() {
        this.database = new ArrayList<>();
        database.add(new Persona(1100, "gus", "are", "san", 1.1f, true));
        database.add(new Persona(2100, "tavo", "fox", "foo", 1.2f, true));
    }
    //@select * from personas 
    public List<Persona> getAll() {
        return this.database;
    }
  //@select * from personas where id = #{id}
    public Persona getPersona(int id) {
        Optional<Persona> encontrado = database.stream().filter(x -> x.getId()==id).findFirst();
        if(encontrado.isPresent()) return encontrado.get();
        return null;
    }
    //@ into personas values (0, #{nombre}, #{apMaterno}, #{apPaterno}, #{sueldo}, #{genero});
    public int insert(Persona persona) {
        Persona p = getPersona(persona.getId());
            if(p==null) database.add(persona);
            return 0;
    }
  //@ personas set nombre = #{nombre}, #{apMaterno}, #{apPaterno}, #{sueldo}, #{genero} where id = #{id}
    public int update(Persona persona) {
       Persona p = getPersona(persona.getId());
       if (p != null) {
           database.remove(p);
           database.add(persona);
        }
            return 0;
     }//update

    //@ from personas where id = #{id}
    public int delete(int id) {
       Persona p = getPersona(id);
       if(p != null) database.remove(p);
       return 0;
    }//delete
}
