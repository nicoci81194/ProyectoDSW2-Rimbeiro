package pe.cib.rimbeiro.dto.Veterinario;

import lombok.Data;
import pe.cib.rimbeiro.model.Especialidad;


@Data
public class VeterinarioDTO {

    private Long id;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Especialidad especialidad;
    private boolean estado;

}
