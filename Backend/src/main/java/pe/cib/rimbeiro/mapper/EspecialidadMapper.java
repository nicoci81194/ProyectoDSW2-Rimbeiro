package pe.cib.rimbeiro.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pe.cib.rimbeiro.dto.Especialidad.EspecialidadCreateDTO;
import pe.cib.rimbeiro.dto.Especialidad.EspecialidadDTO;
import pe.cib.rimbeiro.dto.Especialidad.EspecialidadUpdateDTO;
import pe.cib.rimbeiro.model.Especialidad;

import java.util.List;

@Mapper
public interface EspecialidadMapper {

    EspecialidadMapper instancia = Mappers.getMapper(EspecialidadMapper.class);

    EspecialidadDTO entityAEntityDTO(Especialidad especialidad);
    Especialidad entityDTOAEntity(EspecialidadDTO especialidadDTO);

    //Para create and update
    Especialidad entityCreateDTOAEntity(EspecialidadCreateDTO especialidadCreateDTO);
    Especialidad entityUpdateDTOAEntity(EspecialidadUpdateDTO especialidadUpdateDTO);

    //Para el delete
    List<EspecialidadDTO> listaEntityAlistaEntityDTO(List<Especialidad> especialidadList);

}
