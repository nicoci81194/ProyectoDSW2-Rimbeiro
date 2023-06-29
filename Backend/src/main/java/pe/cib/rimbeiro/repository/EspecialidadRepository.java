package pe.cib.rimbeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.cib.rimbeiro.model.Especialidad;

import java.util.List;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Long> {
    //Activos
    //Inactivos
    List<Especialidad> findAllByEstado(boolean estado);
}
