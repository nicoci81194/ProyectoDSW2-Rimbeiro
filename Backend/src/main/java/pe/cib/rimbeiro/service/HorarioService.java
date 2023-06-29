package pe.cib.rimbeiro.service;

import pe.cib.rimbeiro.dto.Horario.*;
import pe.cib.rimbeiro.dto.Veterinario.VeterinarioDTO;

import java.util.List;

public interface HorarioService {
    List<HorarioDTO> listarHorarios();
    List<HorarioDTO> listarHorariosPorDiaDeSemana(String dia);
    List<HorarioDTO> listarHorariosPorDiaDeSemanaYEstado(String dia, boolean estado);
    List<HorarioDTO> listarHorariosPorEstado(boolean estado);
    List<HorarioDTO> listarHorariosPorVeterinario(VeterinarioDTO veterinarioDTO);
    HorarioDTO obtenerHorarioPorID(Long id);
    HorarioDTO registrarHorario(HorarioCreateDTO horarioCreateDTO);
    HorarioDTO actualizarHorario(HorarioUpdateDTO horarioUpdateDTO);
    HorarioDTO eliminarHorario(Long id);
}
