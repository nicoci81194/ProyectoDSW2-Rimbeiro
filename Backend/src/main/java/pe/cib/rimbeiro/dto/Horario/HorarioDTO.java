package pe.cib.rimbeiro.dto.Horario;

import lombok.Data;
import pe.cib.rimbeiro.model.Veterinario;

@Data
public class HorarioDTO {

    private Long id;

    private String diaSemana;

    private String horaInicio;

    private String horaFin;

    private Veterinario veterinario;

    private boolean estado;
}
