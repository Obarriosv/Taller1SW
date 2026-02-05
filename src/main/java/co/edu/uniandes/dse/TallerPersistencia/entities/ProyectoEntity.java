package co.edu.uniandes.dse.TallerPersistencia.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import jakarta.persistence.*;



@Entity
@Table(name = "proyecto")
public class ProyectoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(length = 1000)
    private String descripcion;

    
    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TareaEntity> tareas = new ArrayList<>();

  
    public void addTarea(TareaEntity tarea) {
        tareas.add(tarea);
        tarea.setProyecto(this);
    }

    public void removeTarea(TareaEntity tarea) {
        tareas.remove(tarea);
        tarea.setProyecto(null);
    }


    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public List<TareaEntity> getTareas() { return tareas; }

    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setTareas(List<TareaEntity> tareas) { this.tareas = tareas; }
}
