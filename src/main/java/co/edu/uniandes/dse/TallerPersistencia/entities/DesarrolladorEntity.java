package co.edu.uniandes.dse.TallerPersistencia.entities;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set; 
@Entity
@Table(name = "desarrollador")

public class DesarrolladorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String correo;

 
    @ManyToMany(mappedBy = "desarrolladores")
    private Set<TareaEntity> tareas = new HashSet<>();

   
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public Set<TareaEntity> getTareas() { return tareas; }

    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setTareas(Set<TareaEntity> tareas) { this.tareas = tareas; }
}
