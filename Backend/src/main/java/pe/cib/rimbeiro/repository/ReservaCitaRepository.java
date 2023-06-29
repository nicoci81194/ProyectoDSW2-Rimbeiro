package pe.cib.rimbeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.cib.rimbeiro.model.Mascota;
import pe.cib.rimbeiro.model.ReservaCita;
import pe.cib.rimbeiro.model.Veterinario;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservaCitaRepository extends JpaRepository<ReservaCita,Long> {
    List<ReservaCita> findByMascota(Mascota mascota);
    List<ReservaCita> findByVeterinario(Veterinario veterinario);
    List<ReservaCita> findByMascotaUsuarioId(Long id);
    //List<ReservaCita> findByFecha (String fecha);
    @Query("SELECT r FROM ReservaCita r WHERE r.fecha = :fecha")
    List<ReservaCita> findAllByFecha(@Param("fecha") Date fecha);
}
