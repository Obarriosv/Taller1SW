package co.edu.uniandes.dse.TallerPersistencia.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;


public class TareaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

  
    private String estado;

    // horas
    private Integer duracionEstimada;

   
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private ProyectoEntity proyecto;

    
    @ManyToMany
    @JoinTable(
        name = "tarea_desarrollador",
        joinColumns = @JoinColumn(name = "tarea_id"),
        inverseJoinColumns = @JoinColumn(name = "desarrollador_id")
    )
    private Set<DesarrolladorEntity> desarrolladores = new HashSet<>();

 
    public void addDesarrollador(DesarrolladorEntity d) {
        desarrolladores.add(d);
        d.getTareas().add(this);
    }

    public void removeDesarrollador(DesarrolladorEntity d) {
        DesarrolladorEntity.remove(d);
        d.getTareas().remove(this);
    }

 
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getEstado() { return estado; }
    public Integer getDuracionEstimada() { return duracionEstimada; }
    public ProyectoEntity getProyecto() { return proyecto; }
    public Set<DesarrolladorEntity> getDesarrolladores() { return desarrolladores; }

    public void setId(Long id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setDuracionEstimada(Integer duracionEstimada) { this.duracionEstimada = duracionEstimada; }
    public void setProyecto(ProyectoEntity proyecto) { this.proyecto = proyecto; }
    public void setDesarrolladores(Set<DesarrolladorEntity> desarrolladores) { this.desarrolladores = desarrolladores; }
}
