package pe.cib.rimbeiro.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pe.cib.rimbeiro.dto.Mascota.*;
import pe.cib.rimbeiro.model.Mascota;

import java.util.List;


@Mapper
public interface MascotaMapper {

    MascotaMapper instancia = Mappers.getMapper(MascotaMapper.class);

    MascotaDTO entityAEntityDTO(Mascota mascota); //obtener usuxid ADMIN
    Mascota entityDTOAEntity(MascotaDTO mascotaDTO);

    Mascota entityCreateDTOAEntity(MascotaCreateDTO mascotaCreateDTO); //admin
    Mascota entityUpdateDTOAEntity(MascotaUpdateDTO mascotaUpdateDTO); //admin

    List<MascotaDTO> listaEntityAlistaEntityDTO(List<Mascota> mascotaList); // lista - ADMIN


}
