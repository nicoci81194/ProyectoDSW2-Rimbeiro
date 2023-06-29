package pe.cib.rimbeiro.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cib.rimbeiro.dto.Mascota.*;
import pe.cib.rimbeiro.mapper.MascotaMapper;
import pe.cib.rimbeiro.model.Mascota;
import pe.cib.rimbeiro.repository.MascotaRepository;
import pe.cib.rimbeiro.service.MascotaService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MascotaServiceImpl implements MascotaService {

    private MascotaRepository repository;

    @Override
    public List<MascotaDTO> listarMascotasAdmin() {
        return MascotaMapper.instancia.listaEntityAlistaEntityDTO(repository.findAll());
    }


    @Override
    public MascotaDTO obtenerMascotaAdminPorID(Long id) {
        Optional<Mascota> optional = repository.findById(id);
        MascotaDTO dto;
        if(optional.isPresent()){
            dto = MascotaMapper.instancia.entityAEntityDTO(optional.get());
        }else{
            dto=null;
        }
        return dto;
    }

    @Override
    public MascotaDTO registrarMascotaAdmin(MascotaCreateDTO mascotaAdminCreateDTO) {
        Mascota entity = MascotaMapper.instancia.entityCreateDTOAEntity(mascotaAdminCreateDTO);
        Mascota rpta = repository.save(entity);
        MascotaDTO rptaDTO = MascotaMapper.instancia.entityAEntityDTO(rpta);
        return rptaDTO;
    }

    @Override
    public MascotaDTO actualizarMascotaAdmin(MascotaUpdateDTO mascotaAdminUpdateDTO) {
        Mascota entity = MascotaMapper.instancia.entityUpdateDTOAEntity(mascotaAdminUpdateDTO);
        Mascota rpta = repository.save(entity);
        MascotaDTO rptaDTO = MascotaMapper.instancia.entityAEntityDTO(rpta);
        return rptaDTO;
    }

    @Override
    public MascotaDTO eliminarMascotaAdmin(Long id) {
        Optional<Mascota> optional = repository.findById(id);
        MascotaDTO dto = new MascotaDTO();
        if(optional.isPresent()){
            dto = MascotaMapper.instancia.entityAEntityDTO(optional.get());
            repository.delete(optional.get());
            return dto;
        }else{
            return dto;
        }
    }

    @Override
    public List<MascotaDTO> listarMascotasEspecie(String especie) {
        return MascotaMapper.instancia.listaEntityAlistaEntityDTO(repository.findByEspecie(especie));
    }
}
