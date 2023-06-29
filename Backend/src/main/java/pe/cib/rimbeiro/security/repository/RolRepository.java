package pe.cib.rimbeiro.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.cib.rimbeiro.security.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol,Long> {
}
