package pe.cib.rimbeiro.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.cib.rimbeiro.dto.Horario.HorarioDTO;
import pe.cib.rimbeiro.dto.Mascota.MascotaDTO;
import pe.cib.rimbeiro.dto.ReservaCita.*;
import pe.cib.rimbeiro.dto.Veterinario.VeterinarioDTO;
import pe.cib.rimbeiro.model.ReservaCita;
import pe.cib.rimbeiro.service.MascotaService;
import pe.cib.rimbeiro.service.ReservaCitaService;
import pe.cib.rimbeiro.service.VeterinarioService;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rimbeiro")
@AllArgsConstructor
public class ReservaCitaController {

    private ReservaCitaService service;

    private MascotaService mascotaService;

    private VeterinarioService vetService;

    @GetMapping("/reservas")
    public ResponseEntity<List<ReservaCitaDTO>> listarReservaCitas(){
        return new ResponseEntity<>(service.listarReservaCitas(), HttpStatus.OK);
    }

    @GetMapping("/reservaDia")
    public ResponseEntity<List<ReservaCitaDTO>> listarReservasPorFecha(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha){
        return new ResponseEntity<>(service.listarReservasPorDia(fecha), HttpStatus.OK);
    }

    @GetMapping("/reserva/{id}")
    public ResponseEntity<ReservaCitaDTO> obtenerReservaCitaPorId(@PathVariable("id") Long id){
        return  new ResponseEntity<> ( service.obtenerReservaCitaPorID(id),HttpStatus.OK);
    }

    @GetMapping("/reservasMascota/{id}")
    public ResponseEntity<List<ReservaCitaDTO>> obtenerReservasDeCitasPorMascota(@PathVariable("id") Long mascotaId) {
        MascotaDTO mascotaDTO = mascotaService.obtenerMascotaAdminPorID(mascotaId);
        List<ReservaCitaDTO> reservasCitas = service.obtenerReservasDeCitasPorMascota(mascotaDTO);
        return ResponseEntity.ok(reservasCitas);
    }

    @GetMapping("/reservasVeterinario/{id}")
    public ResponseEntity<List<ReservaCitaDTO>> obtenerReservasDeCitasPorVeterinario(@PathVariable("id") Long vetId) {
        VeterinarioDTO veterinarioDTO = vetService.obtenerVeterinarioPorId(vetId);
        List<ReservaCitaDTO> reservasCitas = service.obtenerReservasDeCitasPorVeterinario(veterinarioDTO);
        return ResponseEntity.ok(reservasCitas);
    }

    @PostMapping("/reserva")
    public ResponseEntity<ReservaCitaDTO> registrarReservaCita(@Valid @RequestBody ReservaCitaCreateDTO reservaCitaCreateDTO){
        return  new ResponseEntity <>( service.registrarReservaCita(reservaCitaCreateDTO) ,HttpStatus.CREATED) ;
    }

    @PutMapping("/reserva")
    public ResponseEntity<ReservaCitaDTO> actualizarReservaCita(@Valid @RequestBody ReservaCitaUpdateDTO reservaCitaUpdateDTO){
        return new ResponseEntity<>(service.actualizarReservaCita(reservaCitaUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/reserva/{id}")
    public ResponseEntity<ReservaCitaDTO> eliminarReservaCita(@PathVariable("id") Long id) {
        return new ResponseEntity<>( service.eliminarReservaCita(id),HttpStatus.OK);
    }

    @GetMapping("/reservaUsuario/{id}")
    public List<ReservaCita> obtenerReservasCitasPorUsuario(@PathVariable("id") Long idUsuario) {
        return service.obtenerReservasCitasPorUsuario(idUsuario);
    }

}
