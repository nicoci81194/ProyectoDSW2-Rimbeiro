package pe.cib.rimbeiro.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.cib.rimbeiro.dto.Veterinario.*;
import pe.cib.rimbeiro.service.VeterinarioService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rimbeiro")
@AllArgsConstructor
public class VeterinarioController {

    private VeterinarioService service;

    @GetMapping("/veterinarios")
    public ResponseEntity<List<VeterinarioDTO>> listarVeterinarios(@RequestParam(required = false) Boolean estado,
                                                                   @RequestParam(required = false) Long idEspecialidad){
        if(estado == null && idEspecialidad == null){
            return new ResponseEntity<>(service.listarVeterinarios(), HttpStatus.OK);
        } else if(estado == null){
            return new ResponseEntity<>(service.listarVeterinariosPorIdEspecialidad(idEspecialidad), HttpStatus.OK);
        } else if(idEspecialidad == null){
            return new ResponseEntity<>(service.listarVeterinariosPorEstado(estado), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(service.listarVeterinariosPorIdEspecialidadYEstado(idEspecialidad, estado), HttpStatus.OK);
        }

    }

    @GetMapping("/veterinario/{id}")
    public ResponseEntity<VeterinarioDTO> obtenerVeterinarioPorId(@PathVariable("id") long id){
        return  new ResponseEntity<> ( service.obtenerVeterinarioPorId(id),HttpStatus.OK);
    }

    @PostMapping("/veterinario")
    public ResponseEntity<VeterinarioDTO> registrarVeterinario(@Valid @RequestBody VeterinarioCreateDTO veterinarioCreateDTO){
        return  new ResponseEntity <>( service.registrarVeterinario(veterinarioCreateDTO) ,HttpStatus.CREATED) ;
    }

    @PutMapping("/veterinario")
    public ResponseEntity<VeterinarioDTO> actualizarVeterinario(@Valid @RequestBody VeterinarioUpdateDTO veterinarioUpdateDTO){
        return new ResponseEntity<>(service.actualizarVeterinario(veterinarioUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/veterinario/{id}")
    public ResponseEntity<VeterinarioDTO> eliminarVeterinario(@PathVariable("id") long id) {
        return new ResponseEntity<>( service.eliminarVeterinario(id),HttpStatus.OK);
    }


}
