package pe.cib.rimbeiro.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cib.rimbeiro.dto.Mascota.MascotaDTO;
import pe.cib.rimbeiro.dto.ReservaCita.*;
import pe.cib.rimbeiro.dto.Veterinario.VeterinarioDTO;
import pe.cib.rimbeiro.mapper.MascotaMapper;
import pe.cib.rimbeiro.mapper.ReservaCitaMapper;
import pe.cib.rimbeiro.mapper.VeterinarioMapper;
import pe.cib.rimbeiro.model.Mascota;
import pe.cib.rimbeiro.model.ReservaCita;
import pe.cib.rimbeiro.model.Veterinario;
import pe.cib.rimbeiro.repository.ReservaCitaRepository;
import pe.cib.rimbeiro.service.ReservaCitaService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservaCitaServiceImlp implements ReservaCitaService {

    private ReservaCitaRepository repository;

    @Override
    public List<ReservaCitaDTO> listarReservaCitas() {
        return ReservaCitaMapper.instancia.listaEntityAlistaEntityDTO(repository.findAll());
    }

    @Override
    public List<ReservaCitaDTO> obtenerReservasDeCitasPorMascota(MascotaDTO mascotaDTO) {
        Mascota mascota = MascotaMapper.instancia.entityDTOAEntity(mascotaDTO);
        List<ReservaCita> reservasCitas = repository.findByMascota(mascota);
        return ReservaCitaMapper.instancia.listaEntityAlistaEntityDTO(reservasCitas);
    }

    @Override
    public List<ReservaCitaDTO> obtenerReservasDeCitasPorVeterinario(VeterinarioDTO veterinarioDTO) {
        Veterinario veterinario = VeterinarioMapper.instancia.entityDTOAEntity(veterinarioDTO);
        List<ReservaCita> reservasCitas = repository.findByVeterinario(veterinario);
        return ReservaCitaMapper.instancia.listaEntityAlistaEntityDTO(reservasCitas);
    }

    @Override
    public ReservaCitaDTO obtenerReservaCitaPorID(Long id) {
        Optional<ReservaCita> optional = repository.findById(id);
        ReservaCitaDTO dto;
        if(optional.isPresent()){
            dto = ReservaCitaMapper.instancia.entityAEntityDTO(optional.get());
        }else{
            dto=null;
        }
        return dto;
    }

    @Override
    public ReservaCitaDTO registrarReservaCita(ReservaCitaCreateDTO reservaCitaCreateDTO) {
        ReservaCita entity = ReservaCitaMapper.instancia.entityCreateDTOAEntity(reservaCitaCreateDTO);
        ReservaCita rpta = repository.save(entity);
        ReservaCitaDTO rptaDTO = ReservaCitaMapper.instancia.entityAEntityDTO(rpta);
        return rptaDTO;
    }

    @Override
    public ReservaCitaDTO actualizarReservaCita(ReservaCitaUpdateDTO reservaCitaUpdateDTO) {
        ReservaCita entity = ReservaCitaMapper.instancia.entityUpdateDTOAEntity(reservaCitaUpdateDTO);
        ReservaCita rpta = repository.save(entity);
        ReservaCitaDTO rptaDTO = ReservaCitaMapper.instancia.entityAEntityDTO(rpta);
        return rptaDTO;
    }

    @Override
    public ReservaCitaDTO eliminarReservaCita(Long id) {
        Optional<ReservaCita> optional = repository.findById(id);
        ReservaCitaDTO dto = new ReservaCitaDTO();
        if(optional.isPresent()){
            dto = ReservaCitaMapper.instancia.entityAEntityDTO(optional.get());
            repository.delete(optional.get());
            return dto;
        }else{
            return dto;
        }
    }

    //

    @Override
    public List<ReservaCita> obtenerReservasCitasPorUsuario(Long idUsuario) {
        return repository.findByMascotaUsuarioId(idUsuario);
    }

    @Override
    public List<ReservaCitaDTO> listarReservasPorDia(Date fecha) {
        List<ReservaCita> reservaCitas = repository.findAllByFecha(fecha);
        return ReservaCitaMapper.instancia.listaEntityAlistaEntityDTO(reservaCitas);
    }
}
