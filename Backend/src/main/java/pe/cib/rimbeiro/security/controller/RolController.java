package pe.cib.rimbeiro.security.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.cib.rimbeiro.security.model.Rol;
import pe.cib.rimbeiro.security.service.RolService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rimbeiro")
@AllArgsConstructor
public class RolController {

    private RolService service;

    @GetMapping("/roles")
    public ResponseEntity<List<Rol>> getAllRoles() {
        List<Rol> roles = service.listarRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @PostMapping("/rol")
    public ResponseEntity<Rol> guardarRol(@RequestBody @Valid Rol rol) {
        Rol rolGuardado = service.guardarRol(rol);
        return ResponseEntity.status(HttpStatus.CREATED).body(rolGuardado);
    }

}
