package pe.cib.rimbeiro.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "tb_rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "rol")
    @JsonIgnore
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();

    public Rol(){

    }

    public Rol(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

}
