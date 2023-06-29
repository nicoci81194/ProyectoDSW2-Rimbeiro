package pe.cib.rimbeiro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tb_reserva_cita")
@Data
public class ReservaCita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_mascota")
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "id_veterinario")
    private Veterinario veterinario;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private String hora;

    @Column(nullable = false)
    private boolean estado = true;

    //  -   -   -   -   -   -   -   -    -   -   -

    @JsonIgnore
    @OneToOne(mappedBy = "reservaCita", cascade = CascadeType.ALL)
    private Receta receta;

}