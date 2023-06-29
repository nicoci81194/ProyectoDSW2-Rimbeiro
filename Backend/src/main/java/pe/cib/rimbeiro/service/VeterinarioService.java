package pe.cib.rimbeiro.service;

import pe.cib.rimbeiro.dto.Veterinario.*;

import java.util.List;

public interface VeterinarioService {

    List<VeterinarioDTO> listarVeterinarios();
    List<VeterinarioDTO> listarVeterinariosPorIdEspecialidad(Long id);
    List<VeterinarioDTO> listarVeterinariosPorEstado(boolean estado);
    List<VeterinarioDTO> listarVeterinariosPorIdEspecialidadYEstado(Long id, boolean estado);
    VeterinarioDTO obtenerVeterinarioPorId(Long id);
    VeterinarioDTO registrarVeterinario(VeterinarioCreateDTO veterinarioCreateDTO);
    VeterinarioDTO actualizarVeterinario(VeterinarioUpdateDTO veterinarioUpdateDTO);
    VeterinarioDTO eliminarVeterinario(Long id);

}
