package pe.cib.rimbeiro.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pe.cib.rimbeiro.dto.ReservaCita.*;
import pe.cib.rimbeiro.model.ReservaCita;

import java.util.List;

@Mapper
public interface ReservaCitaMapper {

    ReservaCitaMapper instancia = Mappers.getMapper(ReservaCitaMapper.class);

    ReservaCitaDTO entityAEntityDTO(ReservaCita reservaCita);
    ReservaCita entityDTOAEntity(ReservaCitaDTO reservaCitaDTO);

    //Para create and update
    ReservaCita entityCreateDTOAEntity(ReservaCitaCreateDTO reservaCitaCreateDTO);
    ReservaCita entityUpdateDTOAEntity(ReservaCitaUpdateDTO reservaCitaUpdateDTO);

    //Para el delete
    List<ReservaCitaDTO> listaEntityAlistaEntityDTO(List<ReservaCita> reservaCitaList);

}
