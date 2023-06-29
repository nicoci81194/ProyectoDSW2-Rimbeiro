package pe.cib.rimbeiro.dto.Horario;

import lombok.Data;
import pe.cib.rimbeiro.model.Veterinario;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class HorarioUpdateDTO {
    private Long id;

    @Pattern(regexp = "^(?i)(lunes|martes|mi[ée]rcoles|jueves|viernes|s[áa]bado|domingo)(,(lunes|martes|mi[ée]rcoles|jueves|viernes|s[áa]bado|domingo))*$", message = "Ingrese uno o más días de la semana válidos separados por guiones")
    private String diaSemana;

    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$", message = "Ingrese una hora válida")
    private String horaInicio;

    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$", message = "Ingrese una hora válida")
    private String horaFin;

    private Veterinario veterinario;

    private boolean estado;
}
