package pe.cib.rimbeiro.dto.ReservaCita;

import lombok.Data;
import pe.cib.rimbeiro.model.Mascota;
import pe.cib.rimbeiro.model.Veterinario;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class ReservaCitaCreateDTO {
    private Mascota mascota;
    private Veterinario veterinario;

    @FutureOrPresent(message = "La fecha debe ser igual o posterior a la fecha actual")
    private Date fecha;
    @NotBlank
    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$", message = "Ingrese una hora válida")
    private String hora;
}
