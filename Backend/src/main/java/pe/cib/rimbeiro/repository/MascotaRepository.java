package pe.cib.rimbeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.cib.rimbeiro.model.Mascota;

import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    @Query("SELECT m FROM Mascota m WHERE m.especie = :especie")
    List<Mascota> findByEspecie(@Param("especie") String especie);
}
