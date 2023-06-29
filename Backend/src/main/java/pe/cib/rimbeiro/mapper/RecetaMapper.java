package pe.cib.rimbeiro.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pe.cib.rimbeiro.dto.Receta.*;
import pe.cib.rimbeiro.model.Receta;

import java.util.List;

@Mapper
public interface RecetaMapper {

    RecetaMapper instancia = Mappers.getMapper(RecetaMapper.class);

    RecetaDTO entityAEntityDTO(Receta receta);
    Receta entityDTOAEntity(RecetaDTO recetaDTO);

    //Para create and update
    Receta entityCreateDTOAEntity(RecetaCreateDTO recetaCreateDTO);
    Receta entityUpdateDTOAEntity(RecetaUpdateDTO recetaUpdateDTO);

    //Para el delete
    List<RecetaDTO> listaEntityAlistaEntityDTO(List<Receta> recetaList);

}
