package co.edu.uniandes.dse.TallerPersistencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uniandes.dse.TallerPersistencia.entities.ProyectoEntity;

public interface ProyectoRepository extends JpaRepository<ProyectoEntity, Long> {

}
