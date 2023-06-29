package pe.cib.rimbeiro.service;

import pe.cib.rimbeiro.dto.Especialidad.*;


import java.util.List;

public interface EspecialidadService {

    List<EspecialidadDTO> listarEspecialidades();
    List<EspecialidadDTO> listarEspecialidadesPorEstado(boolean estado);
    EspecialidadDTO obtenerEspecialidadPorID(Long id);
    EspecialidadDTO registrarEspecialidad(EspecialidadCreateDTO especialidadcreateDTO);
    EspecialidadDTO actualizarEspecialidad(EspecialidadUpdateDTO especialidadUpdateDTO);
    EspecialidadDTO eliminarEspecialidad(Long id);

}
