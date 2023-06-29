package pe.cib.rimbeiro.security.service.impl;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.cib.rimbeiro.model.Mascota;
import pe.cib.rimbeiro.security.excepciones.UsuarioFoundException;
import pe.cib.rimbeiro.security.excepciones.UsuarioNotFoundException;
import pe.cib.rimbeiro.security.model.Usuario;
import pe.cib.rimbeiro.security.model.UsuarioRol;
import pe.cib.rimbeiro.security.repository.RolRepository;
import pe.cib.rimbeiro.security.repository.UsuarioRepository;
import pe.cib.rimbeiro.security.service.UsuarioService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    private RolRepository rolRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        if(usuarioLocal != null){
            System.out.println("El usuario ya existe");
            throw new UsuarioFoundException("El usuario ya esta presente");
        }
        else{
            for(UsuarioRol usuarioRol:usuarioRoles){
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuarioLocal = usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        Optional<Usuario> optional = usuarioRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }else{
            return null;
        }
    }


    @Override
    public void desactivarUsuario(Long usuarioId) {
        usuarioRepository.deactivateUserById(usuarioId);
    }

    @Override
    public void activarUsuario(Long usuarioId) {
        usuarioRepository.activateUserById(usuarioId);
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }

    @Override
    public List<Usuario> listar(Boolean estado) {
        if(estado == null){
            return usuarioRepository.findAll();
        }else{
            return usuarioRepository.findAllByEnabled(estado);
        }
    }

    @Override
    public Usuario actualizarUsuario(Long id, Usuario usuario) throws Exception {
        // Verifica si el usuario existe en la base de datos
        Optional<Usuario> usuarioExistenteOptional = usuarioRepository.findById(id);
        if (!usuarioExistenteOptional.isPresent()) {
            throw new Exception("El usuario no existe");
        }

        Usuario usuarioExistente = usuarioExistenteOptional.get();

        // Actualiza los campos del usuario existente con los valores del usuario pasado como argumento
        usuarioExistente.setUsername(usuario.getUsername());
        usuarioExistente.setPassword(usuario.getPassword());
        usuarioExistente.setNombre(usuario.getNombre());
        usuarioExistente.setApellido(usuario.getApellido());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setTelefono(usuario.getTelefono());
        usuarioExistente.setEnabled(usuario.isEnabled());
        // Actualiza otros campos según sea necesario

        // Guarda los cambios en la base de datos
        Usuario usuarioActualizado = usuarioRepository.save(usuarioExistente);

        return usuarioActualizado;
    }

    @Override
    public List<Mascota> listarMascotasDeUsuario(Long usuarioId) throws Exception {
        Optional<Usuario> optional = usuarioRepository.findById(usuarioId);
        if (optional.isPresent()){
            Usuario usu = optional.get();
            return usu.getMascotas();
        }else {
            throw new UsuarioNotFoundException("Usuario no encontrado");
        }
    }

}


    /*@Override
    public Usuario actualizarUsuario(Usuario usuario) throws Exception {
        // Verifica si el usuario existe en la base de datos
        Usuario usuarioExistente = usuarioRepository.findByUsername(usuario.getUsername());
        if (usuarioExistente == null) {
            throw new Exception("El usuario no existe");
        }
        // Actualiza los campos del usuario existente con los valores del usuario pasado como argumento
        usuarioExistente.setUsername(usuario.getUsername());
        usuarioExistente.setPassword(usuario.getPassword());
        usuarioExistente.setNombre(usuario.getNombre());
        usuarioExistente.setApellido(usuario.getApellido());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setTelefono(usuario.getTelefono());
        usuarioExistente.setEnabled(usuario.isEnabled());
        // Actualiza otros campos según sea necesario

        // Guarda los cambios en la base de datos
        Usuario usuarioActualizado = usuarioRepository.save(usuarioExistente);

        return usuarioActualizado;
    }*/

















