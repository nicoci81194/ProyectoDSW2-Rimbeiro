package pe.cib.rimbeiro.security.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.cib.rimbeiro.model.Mascota;
import pe.cib.rimbeiro.security.excepciones.RolNotFoundException;
import pe.cib.rimbeiro.security.model.Rol;
import pe.cib.rimbeiro.security.model.Usuario;
import pe.cib.rimbeiro.security.model.UsuarioRol;
import pe.cib.rimbeiro.security.repository.RolRepository;
import pe.cib.rimbeiro.security.service.UsuarioService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/rimbeiro")
@AllArgsConstructor
public class UsuarioController {

    private UsuarioService usuarioService;

    private RolRepository rolRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/usuario")
    public ResponseEntity<Usuario> guardarUsuarioRol(@RequestBody @Valid Usuario usuario, @RequestParam Long rolId) throws Exception{
        usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));

        Set<UsuarioRol> usuarioRoles = new HashSet<>();

        Rol rol = rolRepository.findById(rolId)
                .orElseThrow(() -> new RolNotFoundException("El rol especificado no existe, intenta de nuevo"));

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        usuarioRoles.add(usuarioRol);
        return new ResponseEntity<>(usuarioService.guardarUsuario(usuario, usuarioRoles), HttpStatus.CREATED);

    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> listarUsuarios(@RequestParam(required = false) Boolean estado){
        //return usuarioService.listar(estado);
        return new ResponseEntity<>(usuarioService.listar(estado), HttpStatus.OK);
    }

    @GetMapping("/usuario/{username}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("username") String username){
        //return usuarioService.obtenerUsuario(username);
        return new ResponseEntity<>(usuarioService.obtenerUsuario(username), HttpStatus.OK);
    }

    @DeleteMapping("/usuario/{usuarioId}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable("usuarioId") Long usuarioId){
        usuarioService.eliminarUsuario(usuarioId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/usuarioInactivo/{usuarioId}")
    public ResponseEntity<Void> desactivarUsuario(@PathVariable("usuarioId") Long usuarioId){
        usuarioService.desactivarUsuario(usuarioId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/usuarioActivo/{usuarioId}")
    public ResponseEntity<Void> activarUsuario(@PathVariable("usuarioId") Long usuarioId){
        usuarioService.activarUsuario(usuarioId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        Usuario usuarioExistente = usuarioService.obtenerUsuarioPorId(id);
        if (usuarioExistente == null) {
            return ResponseEntity.notFound().build();
        }

        // Verificar si la contraseña ha cambiado
        if (!usuario.getPassword().equals(usuarioExistente.getPassword())) {
            // La contraseña ha cambiado, encriptarla nuevamente
            usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
        }

        try {
            Usuario usuarioActualizado = usuarioService.actualizarUsuario(id, usuario);
            return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/usuariomascota/{id}")
    public ResponseEntity<List<Mascota>> listarMascotasDeUsuario(@PathVariable Long id) throws Exception {
        List<Mascota> mascotas = usuarioService.listarMascotasDeUsuario(id);
        //return ResponseEntity.ok(mascotas);
        return new ResponseEntity<>(mascotas, HttpStatus.OK);
    }

    @GetMapping("/usuariosid/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(HttpServletRequest request, @PathVariable("id") Long id) {
        // Aquí puedes incluir la lógica adicional que necesites, como validar la autenticación o los permisos

        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

    /*@PutMapping("/usuario/{username}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable("username") String username, @RequestBody Usuario usuario) throws Exception {
        //return usuarioService.actualizarUsuario(usuario);
        return new ResponseEntity<>(usuarioService.actualizarUsuario(usuario), HttpStatus.OK);
    }*/