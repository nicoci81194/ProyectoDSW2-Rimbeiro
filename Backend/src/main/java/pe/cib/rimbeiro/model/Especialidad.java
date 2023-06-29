package pe.cib.rimbeiro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="tb_especialidad")
@Data
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private boolean estado = true;

    // -    -   -   -   -   -   -

    @JsonIgnore
    @OneToMany(mappedBy = "especialidad", cascade = CascadeType.ALL)
    private List<Veterinario> veterinarios;

}
