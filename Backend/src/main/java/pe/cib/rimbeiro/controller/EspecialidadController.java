package pe.cib.rimbeiro.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.cib.rimbeiro.dto.Especialidad.*;
import pe.cib.rimbeiro.service.EspecialidadService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rimbeiro")
@AllArgsConstructor
public class EspecialidadController {

    private EspecialidadService service;

    @GetMapping("/especialidades")
    public ResponseEntity<List<EspecialidadDTO>> listarEspecialidades(@RequestParam(required = false) Boolean estado){
        if(estado == null){
            return new ResponseEntity<>(service.listarEspecialidades(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(service.listarEspecialidadesPorEstado(estado), HttpStatus.OK);
        }
    }

    @GetMapping("/especialidad/{id}")
    public ResponseEntity<EspecialidadDTO> obtenerEspecialidadPorId(@PathVariable("id") long id){
        return  new ResponseEntity<> ( service.obtenerEspecialidadPorID(id),HttpStatus.OK);
    }

    @PostMapping("/especialidad")
    public ResponseEntity<EspecialidadDTO> registrarEspecialidad(@Valid @RequestBody EspecialidadCreateDTO especialidadCreateDTO){
        return  new ResponseEntity <>( service.registrarEspecialidad(especialidadCreateDTO) ,HttpStatus.CREATED) ;
    }

    @PutMapping("/especialidad")
    public ResponseEntity<EspecialidadDTO> actualizarEspecialidad(@Valid @RequestBody EspecialidadUpdateDTO especialidadUpdateDTO){
        return new ResponseEntity<>(service.actualizarEspecialidad(especialidadUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/especialidad/{id}")
    public ResponseEntity<EspecialidadDTO> eliminarEspecialidad(@PathVariable("id") long id) {
        return new ResponseEntity<>( service.eliminarEspecialidad(id),HttpStatus.OK);
    }

}
