package pe.cib.rimbeiro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="tb_veterinario")
@Data
public class Veterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String nombres;

    @Column(name="ape_pat",length = 100, nullable = false)
    private String apellidoPaterno;

    @Column(name="ape_mat",length = 100, nullable = false)
    private String apellidoMaterno;

    @ManyToOne
    @JoinColumn(name = "id_especialidad")
    private Especialidad especialidad;

    @Column(nullable = false)
    private boolean estado = false;

    // -    -   -   -   -   -   -   -

    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Horario> horarios;

    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ReservaCita> reservasCitas;

}

