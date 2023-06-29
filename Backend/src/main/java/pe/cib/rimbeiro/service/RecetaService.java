package pe.cib.rimbeiro.service;

import pe.cib.rimbeiro.dto.Receta.*;
import pe.cib.rimbeiro.dto.ReservaCita.ReservaCitaDTO;

import java.util.List;

public interface RecetaService {
    List<RecetaDTO> listarRecetas();
    List<RecetaDTO> listarRecetaPorReserva(ReservaCitaDTO reservaCitaDTO);
    RecetaDTO obtenerRecetaPorID(Long id);
    RecetaDTO registrarReceta(RecetaCreateDTO recetaCreateDTO);
    RecetaDTO actualizarReceta(RecetaUpdateDTO recetaUpdateDTO);
    RecetaDTO eliminarReceta(Long id);
}
