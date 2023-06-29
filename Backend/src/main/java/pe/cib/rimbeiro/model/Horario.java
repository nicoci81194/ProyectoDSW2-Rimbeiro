package pe.cib.rimbeiro.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="tb_horario")
@Data
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String diaSemana;

    @Column(nullable = false)
    private String horaInicio;

    @Column(nullable = false)
    private String horaFin;

    @ManyToOne
    @JoinColumn(name = "id_veterinario")
    private Veterinario veterinario;

    @Column(nullable = false)
    private boolean estado = true;
}
