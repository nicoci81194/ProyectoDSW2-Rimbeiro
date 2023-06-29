package pe.cib.rimbeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.cib.rimbeiro.model.Receta;
import pe.cib.rimbeiro.model.ReservaCita;

import java.util.List;

@Repository
public interface RecetaRepository extends JpaRepository<Receta, Long> {
    List<Receta> findByReservaCita(ReservaCita reservaCita);
}
