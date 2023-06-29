package pe.cib.rimbeiro.dto.Mascota;

import lombok.Data;
import pe.cib.rimbeiro.security.model.Usuario;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class MascotaUpdateDTO {
    private Long id;
    private Usuario usuario;
    @Pattern(regexp = "^[a-zA-ZñÑ\\s]{2,50}$", message = "Entre 2 y 50 carácteres")
    private String nombre;
    @Pattern(regexp = "^(perro|gato|conejo|loro|perico|hamster|huron|otro)$",
            message = "Especie inválida. Las opciones permitidas son: perro, gato, conejo, loro, perico, hamster, huron u otro.")
    private String especie;
    @Pattern(regexp = "^[a-zA-ZñÑ\\s]{3,50}$", message = "Entre 3 y 50 carácteres")
    private String raza;
    @Past(message = "La fecha de nacimiento debe ser una fecha pasada")
    private Date fechaNacimiento;
    @PositiveOrZero
    private BigDecimal peso;
    @Pattern(regexp = "^[a-zA-ZñÑ\\s]{3,50}$", message = "Entre 3 y 255 carácteres")
    private String caracteristicas;
    private boolean estado;
}
