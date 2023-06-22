package com.example.helloworld.personas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import org.apache.ibatis.exceptions.PersistenceException;

@Repository
public interface PersonaMapper {

    @Select( "select * from personas" )
    public List<Persona> getAll();
    
   @Select("select * from personas where id = #{id}")
    public Persona getPersona(int id);
    
    @Insert( "INSERT INTO personas values (0, #{nombre}, #{apPaterno}, #{apMaterno}, #{sueldo}, #{genero})")
    public int insert(Persona persona);
    
   @Update(" UPDATE personas set nombre = #{nombre}, apPaterno = #{apPaterno}, apMaterno= #{apMaterno}, sueldo= #{sueldo}, genero=#{genero} where id = #{id}")
    public int update(Persona persona);
    
    @Delete(" DELETE from personas where id = #{id}")
    public int delete(int id);
}
