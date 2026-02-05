package co.edu.uniandes.dse.TallerPersistencia.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

public class ProyectoEntity {
    
    private String nombre;

    private String descripcion;

    @OneToMany(mappedBy = "proyecto",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private List<TareaEntity> tareas = new ArrayList<>();
}
