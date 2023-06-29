package pe.cib.rimbeiro;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pe.cib.rimbeiro.security.excepciones.UsuarioFoundException;
import pe.cib.rimbeiro.security.model.Rol;
import pe.cib.rimbeiro.security.model.Usuario;
import pe.cib.rimbeiro.security.model.UsuarioRol;
import pe.cib.rimbeiro.security.repository.RolRepository;
import pe.cib.rimbeiro.security.service.RolService;
import pe.cib.rimbeiro.security.service.UsuarioService;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private RolService rolService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void run(String... args) throws Exception {
/*
			try{
				Rol adminR = new Rol();
				adminR.setDescripcion("ADMIN");
				rolService.guardarRol(adminR);

				Rol usuarioR = new Rol();
				usuarioR.setDescripcion("USUARIO");
				rolService.guardarRol(usuarioR);

				Rol veterinarioR = new Rol();
				veterinarioR.setDescripcion("VETERINARIO");
				rolService.guardarRol(veterinarioR);

				// *	*	*	*	*	*	*	*	*

				Usuario usuario = new Usuario();

				usuario.setNombre("Karen");
				usuario.setApellido("Jugo Torres");
				usuario.setUsername("nicole07");
				usuario.setPassword(bCryptPasswordEncoder.encode("12345"));
				usuario.setEmail("c1@gmail.com");
				usuario.setTelefono("988212020");

				Rol rol = new Rol();
				rol.setId(1L);
				rol.setDescripcion("ADMIN");


				Set<UsuarioRol> usuariosRoles = new HashSet<>();
				UsuarioRol usuarioRol = new UsuarioRol();
				usuarioRol.setRol(rol);
				usuarioRol.setUsuario(usuario);
				usuariosRoles.add(usuarioRol);

				Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario,usuariosRoles);
				System.out.println(usuarioGuardado.getUsername());
			}catch(UsuarioFoundException exception){
				exception.printStackTrace();
			}
*/


	}

}
