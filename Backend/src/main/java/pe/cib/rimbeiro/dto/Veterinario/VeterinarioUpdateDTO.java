package pe.cib.rimbeiro.dto.Veterinario;

import lombok.Data;
import pe.cib.rimbeiro.model.Especialidad;

import javax.validation.constraints.Pattern;

@Data
public class VeterinarioUpdateDTO {

    private Long id;
    @Pattern(regexp = "^[a-zA-ZñÑ\\s]{3,200}$", message = "Entre 3 y 200 carácteres")
    private String nombres;
    @Pattern(regexp = "^[a-zA-ZñÑ\\s]{3,100}$", message = "Entre 3 y 100 carácteres")
    private String apellidoPaterno;
    @Pattern(regexp = "^[a-zA-ZñÑ\\s]{3,100}$", message = "Entre 3 y 100 carácteres")
    private String apellidoMaterno;
    private Especialidad especialidad;
    private boolean estado;

}
