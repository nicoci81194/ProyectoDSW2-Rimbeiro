package pe.cib.rimbeiro.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.cib.rimbeiro.dto.Horario.*;
import pe.cib.rimbeiro.dto.Veterinario.VeterinarioDTO;
import pe.cib.rimbeiro.service.HorarioService;
import pe.cib.rimbeiro.service.VeterinarioService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rimbeiro")
@AllArgsConstructor
public class HorarioController {

    private HorarioService service;

    private VeterinarioService vetService;

    @GetMapping("/horarios")
    public ResponseEntity<List<HorarioDTO>> listarHorarios(@RequestParam(required = false)Boolean estado,
                                                           @RequestParam(required = false)String dia){
        if(estado == null && dia == null){
            return new ResponseEntity<>(service.listarHorarios(), HttpStatus.OK);
        }else if(estado == null){
            return new ResponseEntity<>(service.listarHorariosPorDiaDeSemana(dia), HttpStatus.OK);
        }else if(dia == null){
            return new ResponseEntity<>(service.listarHorariosPorEstado(estado), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(service.listarHorariosPorDiaDeSemanaYEstado(dia, estado), HttpStatus.OK);
        }
    }

    @GetMapping("/horarios/{id}")
    public ResponseEntity<List<HorarioDTO>> obtenerHorariosPorVeterinario(@PathVariable("id") Long Id) {
        VeterinarioDTO vetDTO = vetService.obtenerVeterinarioPorId(Id);
        List<HorarioDTO> horarios = service.listarHorariosPorVeterinario(vetDTO);
        return ResponseEntity.ok(horarios);
    }

    @GetMapping("/horario/{id}")
    public ResponseEntity<HorarioDTO> obtenerHorarioPorId(@PathVariable("id") long id){
        return  new ResponseEntity<> ( service.obtenerHorarioPorID(id),HttpStatus.OK);
    }

    @PostMapping("/horario")
    public ResponseEntity<HorarioDTO> registrarHorario(@Valid @RequestBody HorarioCreateDTO horarioCreateDTO){
        return  new ResponseEntity <>( service.registrarHorario(horarioCreateDTO) ,HttpStatus.CREATED) ;
    }

    @PutMapping("/horario")
    public ResponseEntity<HorarioDTO> actualizarHorario(@Valid @RequestBody HorarioUpdateDTO horarioUpdateDTO){
        return new ResponseEntity<>(service.actualizarHorario(horarioUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/horario/{id}")
    public ResponseEntity<HorarioDTO> eliminarHorario(@PathVariable("id") long id) {
        return new ResponseEntity<>( service.eliminarHorario(id),HttpStatus.OK);
    }
}
