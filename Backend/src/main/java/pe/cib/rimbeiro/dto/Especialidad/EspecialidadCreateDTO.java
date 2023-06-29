package pe.cib.rimbeiro.dto.Especialidad;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class EspecialidadCreateDTO {
    @NotBlank
    @Pattern(regexp = "^[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]{5,200}$", message = "Entre 5 y 200 carácteres")
    private String descripcion;

}
