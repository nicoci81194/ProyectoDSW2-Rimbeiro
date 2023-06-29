package pe.cib.rimbeiro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pe.cib.rimbeiro.security.model.Usuario;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="tb_mascota")
@Data
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(length = 50,nullable = false)
    private String nombre;

    @Column(length = 50,nullable = false)
    private String especie;

    @Column(length = 50,nullable = false)
    private String raza;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fec_nac", nullable = false)
    private Date fechaNacimiento;

    @Column(nullable = false)
    private BigDecimal peso;

    @Column(nullable = false)
    private String caracteristicas;

    @Column(nullable = false)
    private boolean estado = true;

    // -    -   -   -   -   -   -   -   -

    @JsonIgnore
    @OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL)
    private List<ReservaCita> reservasCitas;

}