package pe.cib.rimbeiro.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pe.cib.rimbeiro.dto.Veterinario.*;
import pe.cib.rimbeiro.model.Veterinario;

import java.util.List;

@Mapper
public interface VeterinarioMapper {

    VeterinarioMapper instancia = Mappers.getMapper(VeterinarioMapper.class);

    VeterinarioDTO entityAEntityDTO(Veterinario veterinario);
    Veterinario entityDTOAEntity(VeterinarioDTO veterinarioDTO);

    //Para create and update
    Veterinario entityCreateDTOAEntity(VeterinarioCreateDTO veterinarioCreateDTO);
    Veterinario entityUpdateDTOAEntity(VeterinarioUpdateDTO veterinarioUpdateDTO);

    //Para el delete
    List<VeterinarioDTO> listaEntityAlistaEntityDTO(List<Veterinario> veterinarioList);

}
