package pe.cib.rimbeiro.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cib.rimbeiro.dto.Veterinario.*;
import pe.cib.rimbeiro.mapper.VeterinarioMapper;
import pe.cib.rimbeiro.model.Veterinario;
import pe.cib.rimbeiro.repository.VeterinarioRepository;
import pe.cib.rimbeiro.service.VeterinarioService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VeterinarioServiceImpl implements VeterinarioService {

    private VeterinarioRepository repository;

    @Override
    public List<VeterinarioDTO> listarVeterinarios() {
        return VeterinarioMapper.instancia.listaEntityAlistaEntityDTO(repository.findAll());
    }

    @Override
    public List<VeterinarioDTO> listarVeterinariosPorIdEspecialidad(Long id) {
        return VeterinarioMapper.instancia.listaEntityAlistaEntityDTO(repository.findAllByEspecialidadId(id));
    }

    @Override
    public List<VeterinarioDTO> listarVeterinariosPorEstado(boolean estado) {
        return VeterinarioMapper.instancia.listaEntityAlistaEntityDTO(repository.findAllByEstado(estado));
    }

    @Override
    public List<VeterinarioDTO> listarVeterinariosPorIdEspecialidadYEstado(Long id, boolean estado) {
        return VeterinarioMapper.instancia.listaEntityAlistaEntityDTO(repository.findAllByEspecialidadIdAndEstado(id, estado));
    }


    @Override
    public VeterinarioDTO obtenerVeterinarioPorId(Long id) {
        Optional<Veterinario> optional = repository.findById(id);
        VeterinarioDTO dto;
        if(optional.isPresent()){
            dto = VeterinarioMapper.instancia.entityAEntityDTO(optional.get());
        }else{
            dto=null;
        }
        return dto;
    }

    @Override
    public VeterinarioDTO registrarVeterinario(VeterinarioCreateDTO veterinarioCreateDTO) {
        Veterinario entity = VeterinarioMapper.instancia.entityCreateDTOAEntity(veterinarioCreateDTO);
        Veterinario rpta = repository.save(entity);
        VeterinarioDTO rptaDTO = VeterinarioMapper.instancia.entityAEntityDTO(rpta);
        return rptaDTO;
    }

    @Override
    public VeterinarioDTO actualizarVeterinario(VeterinarioUpdateDTO veterinarioUpdateDTO) {
        Veterinario entity = VeterinarioMapper.instancia.entityUpdateDTOAEntity(veterinarioUpdateDTO);
        Veterinario rpta = repository.save(entity);
        VeterinarioDTO rptaDTO = VeterinarioMapper.instancia.entityAEntityDTO(rpta);
        return rptaDTO;
    }

    @Override
    public VeterinarioDTO eliminarVeterinario(Long id) {
        Optional<Veterinario> optional = repository.findById(id);
        VeterinarioDTO dto = new VeterinarioDTO();
        if(optional.isPresent()){
            dto = VeterinarioMapper.instancia.entityAEntityDTO(optional.get());
            repository.delete(optional.get());
            return dto;
        }else{
            return dto;
        }
    }
}
