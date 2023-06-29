package pe.cib.rimbeiro.dto.Mascota;

import lombok.Data;
import pe.cib.rimbeiro.security.model.Usuario;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class MascotaDTO {

    private Long id;
    private Usuario usuario;
    private String nombre;
    private String especie;
    private String raza;
    private Date fechaNacimiento;
    private BigDecimal peso;
    private String caracteristicas;
    private boolean estado;

}
