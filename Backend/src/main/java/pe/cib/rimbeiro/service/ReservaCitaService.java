package pe.cib.rimbeiro.service;

import pe.cib.rimbeiro.dto.Mascota.MascotaDTO;
import pe.cib.rimbeiro.dto.ReservaCita.*;
import pe.cib.rimbeiro.dto.Veterinario.VeterinarioDTO;
import pe.cib.rimbeiro.model.ReservaCita;

import java.util.Date;
import java.util.List;

public interface ReservaCitaService {
    List<ReservaCitaDTO> listarReservaCitas();
    List<ReservaCitaDTO> obtenerReservasDeCitasPorMascota(MascotaDTO mascotaDTO);
    List<ReservaCitaDTO> obtenerReservasDeCitasPorVeterinario(VeterinarioDTO veterinarioDTO);
    ReservaCitaDTO obtenerReservaCitaPorID(Long id);
    ReservaCitaDTO registrarReservaCita(ReservaCitaCreateDTO reservaCitaCreateDTO);
    ReservaCitaDTO actualizarReservaCita(ReservaCitaUpdateDTO reservaCitaUpdateDTO);
    ReservaCitaDTO eliminarReservaCita(Long id);
    //
    List<ReservaCita> obtenerReservasCitasPorUsuario(Long idUsuario);
    List<ReservaCitaDTO> listarReservasPorDia(Date fecha);
}
