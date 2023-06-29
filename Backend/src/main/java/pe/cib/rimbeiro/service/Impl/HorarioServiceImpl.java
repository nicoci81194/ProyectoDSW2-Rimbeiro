package pe.cib.rimbeiro.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cib.rimbeiro.dto.Horario.*;
import pe.cib.rimbeiro.dto.Veterinario.VeterinarioDTO;
import pe.cib.rimbeiro.mapper.HorarioMapper;
import pe.cib.rimbeiro.mapper.VeterinarioMapper;
import pe.cib.rimbeiro.model.Horario;
import pe.cib.rimbeiro.model.Veterinario;
import pe.cib.rimbeiro.repository.HorarioRepository;
import pe.cib.rimbeiro.service.HorarioService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HorarioServiceImpl implements HorarioService {

    private HorarioRepository repository;

    @Override
    public List<HorarioDTO> listarHorarios() {
        return HorarioMapper.instancia.listaEntityAlistaEntityDTO(repository.findAll());
    }

    @Override
    public List<HorarioDTO> listarHorariosPorDiaDeSemana(String dia) {
        return HorarioMapper.instancia.listaEntityAlistaEntityDTO(repository.findAllByDiaSemanaContainingIgnoreCase(dia));
    }

    @Override
    public List<HorarioDTO> listarHorariosPorDiaDeSemanaYEstado(String dia, boolean estado) {
        return HorarioMapper.instancia.listaEntityAlistaEntityDTO(repository.findAllByDiaSemanaAndEstado(dia, estado));
    }

    @Override
    public List<HorarioDTO> listarHorariosPorEstado(boolean estado) {
        return HorarioMapper.instancia.listaEntityAlistaEntityDTO(repository.findAllByEstado(estado));
    }

    @Override
    public List<HorarioDTO> listarHorariosPorVeterinario(VeterinarioDTO veterinarioDTO) {
        Veterinario veterinario = VeterinarioMapper.instancia.entityDTOAEntity(veterinarioDTO);
        List<Horario> horarios = repository.findByVeterinario(veterinario);
        return HorarioMapper.instancia.listaEntityAlistaEntityDTO(horarios);
    }

    @Override
    public HorarioDTO obtenerHorarioPorID(Long id) {
        Optional<Horario> optional = repository.findById(id);
        HorarioDTO dto;
        if(optional.isPresent()){
            dto = HorarioMapper.instancia.entityAEntityDTO(optional.get());
        }else{
            dto=null;
        }
        return dto;
    }

    @Override
    public HorarioDTO registrarHorario(HorarioCreateDTO horarioCreateDTO) {
        Horario entity = HorarioMapper.instancia.entityCreateDTOAEntity(horarioCreateDTO);
        Horario rpta = repository.save(entity);
        HorarioDTO rptaDTO = HorarioMapper.instancia.entityAEntityDTO(rpta);
        return rptaDTO;
    }

    @Override
    public HorarioDTO actualizarHorario(HorarioUpdateDTO horarioUpdateDTO) {
        Horario entity = HorarioMapper.instancia.entityUpdateDTOAEntity(horarioUpdateDTO);
        Horario rpta = repository.save(entity);
        HorarioDTO rptaDTO = HorarioMapper.instancia.entityAEntityDTO(rpta);
        return rptaDTO;
    }

    @Override
    public HorarioDTO eliminarHorario(Long id) {
        Optional<Horario> optional = repository.findById(id);
        HorarioDTO dto = new HorarioDTO();
        if(optional.isPresent()){
            dto = HorarioMapper.instancia.entityAEntityDTO(optional.get());
            repository.delete(optional.get());
            return dto;
        }else{
            return dto;
        }
    }
}
