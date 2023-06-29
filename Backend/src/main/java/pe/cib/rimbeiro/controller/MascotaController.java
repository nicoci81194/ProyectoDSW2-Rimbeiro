package pe.cib.rimbeiro.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.cib.rimbeiro.dto.Mascota.*;
import pe.cib.rimbeiro.service.MascotaService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rimbeiro")
@AllArgsConstructor
public class MascotaController {

    private MascotaService service;

    @GetMapping("/mascotas")
    public ResponseEntity<List<MascotaDTO>> listarMascotasAdmin(){
        return new ResponseEntity<>(service.listarMascotasAdmin(), HttpStatus.OK);
    }

    @GetMapping("/mascotasEspecie/{especie}")
    public ResponseEntity<List<MascotaDTO>> listarMascotasEspecie(@PathVariable("especie") String especie){
        return new ResponseEntity<>(service.listarMascotasEspecie(especie), HttpStatus.OK);
    }

    @GetMapping("/mascota/{id}")
    public ResponseEntity<MascotaDTO> obtenerMascotaAdminPorId(@PathVariable("id") long id){
        return  new ResponseEntity<> ( service.obtenerMascotaAdminPorID(id),HttpStatus.OK);
    }

    @PostMapping("/mascota")
    public ResponseEntity<MascotaDTO> registrarMascotaAdmin(@Valid @RequestBody MascotaCreateDTO mascotaAdminCreateDTO){
        return  new ResponseEntity <>( service.registrarMascotaAdmin(mascotaAdminCreateDTO) ,HttpStatus.CREATED) ;
    }

    @PutMapping("/mascota")
    public ResponseEntity<MascotaDTO> actualizarMascotaAdmin(@Valid @RequestBody MascotaUpdateDTO mascotaAdminUpdateDTO){
        return new ResponseEntity<>(service.actualizarMascotaAdmin(mascotaAdminUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/mascota/{id}")
    public ResponseEntity<MascotaDTO> eliminarMascotaAdmin(@PathVariable("id") long id) {
        return new ResponseEntity<>( service.eliminarMascotaAdmin(id),HttpStatus.OK);
    }


}
