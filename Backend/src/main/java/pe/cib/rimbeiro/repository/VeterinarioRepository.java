package pe.cib.rimbeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.cib.rimbeiro.model.Veterinario;

import java.util.List;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
    List<Veterinario> findAllByEstado(boolean estado);
    List<Veterinario> findAllByEspecialidadId(Long id);
    List<Veterinario> findAllByEspecialidadIdAndEstado(Long id, boolean estado);

}
