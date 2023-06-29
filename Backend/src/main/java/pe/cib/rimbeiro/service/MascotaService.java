package pe.cib.rimbeiro.service;

import pe.cib.rimbeiro.dto.Mascota.*;

import java.util.List;

public interface MascotaService {
    List<MascotaDTO> listarMascotasAdmin();
    MascotaDTO obtenerMascotaAdminPorID(Long id);
    MascotaDTO registrarMascotaAdmin(MascotaCreateDTO mascotaCreateDTO);
    MascotaDTO actualizarMascotaAdmin(MascotaUpdateDTO mascotaUpdateDTO);
    MascotaDTO eliminarMascotaAdmin(Long id);
    List<MascotaDTO> listarMascotasEspecie(String especie);
}
