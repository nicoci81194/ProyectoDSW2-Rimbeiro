package pe.cib.rimbeiro.dto.Receta;

import lombok.Data;
import pe.cib.rimbeiro.model.ReservaCita;

import javax.validation.constraints.Pattern;

@Data
public class RecetaUpdateDTO {
    private Long id;
    private ReservaCita reservaCita;
    @Pattern(regexp = "^[a-zA-ZñÑ\\s]{5,200}$", message = "Entre 5 y 200 carácteres")
    private String diagnostico;
    @Pattern(regexp = "^[a-zA-ZñÑ\\s]{5,800}$", message = "Entre 5 y 800 carácteres")
    private String indicaciones;
}
