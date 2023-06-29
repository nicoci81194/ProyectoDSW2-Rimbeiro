package pe.cib.rimbeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.cib.rimbeiro.model.Horario;
import pe.cib.rimbeiro.model.Veterinario;

import java.util.List;


@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {
    List<Horario> findAllByDiaSemana(String dia);
    List<Horario> findAllByDiaSemanaContainingIgnoreCase(String dia);
    List<Horario> findAllByDiaSemanaAndEstado(String dia, boolean estado);
    List<Horario> findAllByEstado(boolean estado);
    List<Horario> findByVeterinario(Veterinario veterinario);
}
