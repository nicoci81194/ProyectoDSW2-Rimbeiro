package pe.cib.rimbeiro.security.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.cib.rimbeiro.security.config.JwtUtils;
import pe.cib.rimbeiro.security.excepciones.UsuarioNotFoundException;
import pe.cib.rimbeiro.security.model.*;
import pe.cib.rimbeiro.security.service.UsuarioService;
import pe.cib.rimbeiro.security.service.impl.UserDetailsServiceImpl;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //registrar usuario
    @PostMapping("/registrate")
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody @Valid Usuario usuario) throws Exception{
        usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));

        Set<UsuarioRol> usuarioRoles = new HashSet<>();

        Rol rol = new Rol();
        rol.setId(2L);
        rol.setDescripcion("USUARIO");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        usuarioRoles.add(usuarioRol);
        //return usuarioService.guardarUsuario(usuario,usuarioRoles);
        Usuario savedUsuario = usuarioService.guardarUsuario(usuario, usuarioRoles);
        return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
    }

    //login
    @PostMapping("/iniciar-sesion")//generate-token
    public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try{
            autenticar(jwtRequest.getUsername(),jwtRequest.getPassword());
        }catch (UsuarioNotFoundException exception){
            exception.printStackTrace();
            throw new Exception("Usuario no encontrado");
        }

        UserDetails userDetails =  this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void autenticar(String username,String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException exception){
            throw  new Exception("USUARIO DESHABILITADO " + exception.getMessage());
        }catch (BadCredentialsException e){
            throw  new Exception("Credenciales invalidas " + e.getMessage());
        }
    }

    @GetMapping("/actual-usuario")
    public ResponseEntity<Usuario> obtenerUsuarioActual(Principal principal){
        //return (Usuario) this.userDetailsService.loadUserByUsername(principal.getName());
        Usuario usuario = (Usuario) this.userDetailsService.loadUserByUsername(principal.getName());
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
}
