package pe.cib.rimbeiro.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cib.rimbeiro.dto.Especialidad.*;
import pe.cib.rimbeiro.mapper.EspecialidadMapper;
import pe.cib.rimbeiro.model.Especialidad;
import pe.cib.rimbeiro.repository.EspecialidadRepository;
import pe.cib.rimbeiro.service.EspecialidadService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EspecialidadServiceImpl implements EspecialidadService {

    private EspecialidadRepository repository;

    @Override
    public List<EspecialidadDTO> listarEspecialidades() {
        return EspecialidadMapper.instancia.listaEntityAlistaEntityDTO(repository.findAll());
    }

    @Override
    public List<EspecialidadDTO> listarEspecialidadesPorEstado(boolean estado) {
        return EspecialidadMapper.instancia.listaEntityAlistaEntityDTO(repository.findAllByEstado(estado));
    }

    @Override
    public EspecialidadDTO obtenerEspecialidadPorID(Long id) {
        Optional<Especialidad> optional = repository.findById(id);
        EspecialidadDTO dto;
        if(optional.isPresent()){
            dto = EspecialidadMapper.instancia.entityAEntityDTO(optional.get());
        }else{
            dto=null;
        }
        return dto;
    }

    @Override
    public EspecialidadDTO registrarEspecialidad(EspecialidadCreateDTO especialidadcreateDTO) {
        Especialidad entity = EspecialidadMapper.instancia.entityCreateDTOAEntity(especialidadcreateDTO);
        Especialidad rpta = repository.save(entity);
        EspecialidadDTO rptaDTO = EspecialidadMapper.instancia.entityAEntityDTO(rpta);
        return rptaDTO;
    }

    @Override
    public EspecialidadDTO actualizarEspecialidad(EspecialidadUpdateDTO especialidadUpdateDTO) {
        Especialidad entity = EspecialidadMapper.instancia.entityUpdateDTOAEntity(especialidadUpdateDTO);
        Especialidad rpta = repository.save(entity);
        EspecialidadDTO rptaDTO = EspecialidadMapper.instancia.entityAEntityDTO(rpta);
        return rptaDTO;
    }

    @Override
    public EspecialidadDTO eliminarEspecialidad(Long id) {
        Optional<Especialidad> optional = repository.findById(id);
        EspecialidadDTO dto = new EspecialidadDTO();
        if(optional.isPresent()){
            dto = EspecialidadMapper.instancia.entityAEntityDTO(optional.get());
            repository.delete(optional.get());
            return dto;
        }else{
            return dto;
        }
    }
}
