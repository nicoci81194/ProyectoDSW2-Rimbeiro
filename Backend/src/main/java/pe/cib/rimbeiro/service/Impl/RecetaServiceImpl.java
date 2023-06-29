package pe.cib.rimbeiro.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cib.rimbeiro.dto.Receta.*;
import pe.cib.rimbeiro.dto.ReservaCita.ReservaCitaDTO;
import pe.cib.rimbeiro.mapper.RecetaMapper;
import pe.cib.rimbeiro.mapper.ReservaCitaMapper;
import pe.cib.rimbeiro.model.Receta;
import pe.cib.rimbeiro.model.ReservaCita;
import pe.cib.rimbeiro.repository.RecetaRepository;
import pe.cib.rimbeiro.service.RecetaService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RecetaServiceImpl implements RecetaService {

    private RecetaRepository repository;

    @Override
    public List<RecetaDTO> listarRecetas() {
        return RecetaMapper.instancia.listaEntityAlistaEntityDTO(repository.findAll());
    }

    @Override
    public List<RecetaDTO> listarRecetaPorReserva(ReservaCitaDTO reservaCitaDTO) {
        ReservaCita reservaCita = ReservaCitaMapper.instancia.entityDTOAEntity(reservaCitaDTO);
        List<Receta> recetas = repository.findByReservaCita(reservaCita);
        return RecetaMapper.instancia.listaEntityAlistaEntityDTO(recetas);
    }

    @Override
    public RecetaDTO obtenerRecetaPorID(Long id) {
        Optional<Receta> optional = repository.findById(id);
        RecetaDTO dto;
        if(optional.isPresent()){
            dto = RecetaMapper.instancia.entityAEntityDTO(optional.get());
        }else{
            dto=null;
        }
        return dto;
    }

    @Override
    public RecetaDTO registrarReceta(RecetaCreateDTO recetaCreateDTO) {
        Receta entity = RecetaMapper.instancia.entityCreateDTOAEntity(recetaCreateDTO);
        Receta rpta = repository.save(entity);
        RecetaDTO rptaDTO = RecetaMapper.instancia.entityAEntityDTO(rpta);
        return rptaDTO;
    }

    @Override
    public RecetaDTO actualizarReceta(RecetaUpdateDTO recetaUpdateDTO) {
        Receta entity = RecetaMapper.instancia.entityUpdateDTOAEntity(recetaUpdateDTO);
        Receta rpta = repository.save(entity);
        RecetaDTO rptaDTO = RecetaMapper.instancia.entityAEntityDTO(rpta);
        return rptaDTO;
    }

    @Override
    public RecetaDTO eliminarReceta(Long id) {
        Optional<Receta> optional = repository.findById(id);
        RecetaDTO dto = new RecetaDTO();
        if(optional.isPresent()){
            dto = RecetaMapper.instancia.entityAEntityDTO(optional.get());
            repository.delete(optional.get());
            return dto;
        }else{
            return dto;
        }
    }
}
