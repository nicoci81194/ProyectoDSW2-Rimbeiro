package pe.cib.rimbeiro.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.cib.rimbeiro.dto.Receta.*;
import pe.cib.rimbeiro.dto.ReservaCita.ReservaCitaDTO;
import pe.cib.rimbeiro.service.RecetaService;
import pe.cib.rimbeiro.service.ReservaCitaService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rimbeiro")
@AllArgsConstructor
public class RecetaController {

    private RecetaService service;

    private ReservaCitaService citaService;

    @GetMapping("/recetas")
    public ResponseEntity<List<RecetaDTO>> listarRecetas(){
        return new ResponseEntity<>(service.listarRecetas(), HttpStatus.OK);
    }

    @GetMapping("/receta/{id}")
    public ResponseEntity<RecetaDTO> obtenerRecetaPorId(@PathVariable("id") long id){
        return  new ResponseEntity<> ( service.obtenerRecetaPorID(id),HttpStatus.OK);
    }

    @GetMapping("/recetaReserva/{id}")
    public ResponseEntity<List<RecetaDTO>> listarRecetasPorReserva(@PathVariable("id") Long id){
        ReservaCitaDTO reservaCitaDTO = citaService.obtenerReservaCitaPorID(id);
        List<RecetaDTO> recetas = service.listarRecetaPorReserva(reservaCitaDTO);
        return ResponseEntity.ok(recetas);
    }

    @PostMapping("/receta")
    public ResponseEntity<RecetaDTO> registrarReceta(@Valid @RequestBody RecetaCreateDTO recetaCreateDTO){
        return  new ResponseEntity <>( service.registrarReceta(recetaCreateDTO) ,HttpStatus.CREATED) ;
    }

    @PutMapping("/receta")
    public ResponseEntity<RecetaDTO> actualizarReceta(@Valid @RequestBody RecetaUpdateDTO recetaUpdateDTO){
        return new ResponseEntity<>(service.actualizarReceta(recetaUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/receta/{id}")
    public ResponseEntity<RecetaDTO> eliminarReceta(@PathVariable("id") long id) {
        return new ResponseEntity<>( service.eliminarReceta(id),HttpStatus.OK);
    }

}
