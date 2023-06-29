package pe.cib.rimbeiro.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pe.cib.rimbeiro.dto.Horario.*;
import pe.cib.rimbeiro.model.Horario;

import java.util.List;

@Mapper
public interface HorarioMapper {

    HorarioMapper instancia = Mappers.getMapper(HorarioMapper.class);

    HorarioDTO entityAEntityDTO(Horario horario);
    Horario entityDTOAEntity(HorarioDTO horarioDTO);

    //Para create and update
    Horario entityCreateDTOAEntity(HorarioCreateDTO horarioCreateDTO);
    Horario entityUpdateDTOAEntity(HorarioUpdateDTO horarioUpdateDTO);

    //Para el delete
    List<HorarioDTO> listaEntityAlistaEntityDTO(List<Horario> horarioList);

}
