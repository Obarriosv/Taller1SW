package co.edu.uniandes.dse.TallerPersistencia.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class TareaEntity extends BaseEntity {

    private String titulo;

    private String estado;

    private Integer duracionEstimada;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProyectoEntity proyecto;

}
