package pe.cib.rimbeiro.dto.Receta;

import lombok.Data;
import pe.cib.rimbeiro.model.ReservaCita;

import java.util.List;

@Data
public class RecetaDTO {
    private Long id;
    private ReservaCita reservaCita;
}
