package pe.cib.rimbeiro.dto.ReservaCita;

import lombok.Data;
import pe.cib.rimbeiro.model.Mascota;
import pe.cib.rimbeiro.model.Veterinario;

import java.util.Date;

@Data
public class ReservaCitaDTO {
    private Long id;
    private Mascota mascota;
    private Veterinario veterinario;
    private Date fecha;
    private String hora;
    private boolean estado;
}
