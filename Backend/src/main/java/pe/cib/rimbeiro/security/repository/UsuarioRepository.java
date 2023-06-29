package pe.cib.rimbeiro.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.cib.rimbeiro.security.model.Usuario;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Usuario findByUsername(String username);

    List<Usuario> findAllByEnabled(Boolean enabled);

    @Modifying
    @Transactional
    @Query(value = "update Usuario u set u.enabled = false where u.id = :id")
    void deactivateUserById(Long id);

    @Modifying
    @Transactional
    @Query(value = "update Usuario u set u.enabled = true where u.id = :id")
    void activateUserById(Long id);



}
