package pe.cib.rimbeiro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tb_receta")
@Data
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_reserva")
    private ReservaCita reservaCita;

    @Column(length = 200, nullable = false)
    private String diagnostico;

    @Column(length = 800, nullable = false)
    private String indicaciones;
}
