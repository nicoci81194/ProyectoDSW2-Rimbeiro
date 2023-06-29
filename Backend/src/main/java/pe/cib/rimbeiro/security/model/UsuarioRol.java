package pe.cib.rimbeiro.security.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "tb_usuario_rol")
public class UsuarioRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @ManyToOne
    private Rol rol;

    public UsuarioRol() {
        // Constructor vacío requerido por JPA
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, rol);
    }

}
