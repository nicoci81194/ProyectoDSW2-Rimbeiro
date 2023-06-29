package pe.cib.rimbeiro.dto.Veterinario;

import lombok.Data;
import pe.cib.rimbeiro.model.Especialidad;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class VeterinarioCreateDTO {
    @NotBlank
    @Pattern(regexp = "^[a-zA-ZñÑ\\s]{3,200}$", message = "Entre 3 y 200 carácteres")
    private String nombres;
    @NotBlank
    @Pattern(regexp = "^[a-zA-ZñÑ\\s]{3,100}$", message = "Entre 3 y 100 carácteres")
    private String apellidoPaterno;
    @NotBlank
    @Pattern(regexp = "^[a-zA-ZñÑ\\s]{3,100}$", message = "Entre 3 y 100 carácteres")
    private String apellidoMaterno;
    private Especialidad especialidad;
}
