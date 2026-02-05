package co.edu.uniandes.dse.TallerPersistencia.entities;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class DesarrolladorEntity {

    private String nombre;

    private String correo;

    @ManyToMany(mappedBy = "desarrolladores")
    private List<TareaEntity> tareas = new ArrayList<>();

}
