package pe.cib.rimbeiro.security.service;


import pe.cib.rimbeiro.model.Mascota;
import pe.cib.rimbeiro.security.model.Usuario;
import pe.cib.rimbeiro.security.model.UsuarioRol;

import java.util.List;
import java.util.Set;

public interface UsuarioService {

    Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    Usuario obtenerUsuario(String username);

    Usuario obtenerUsuarioPorId(Long id);

    void desactivarUsuario(Long usuarioId);
    void activarUsuario(Long usuarioId);
    void eliminarUsuario(Long usuarioId);

    List<Usuario> listar(Boolean estado);

    //Usuario actualizarUsuario(Usuario usuario) throws Exception;

    Usuario actualizarUsuario(Long id, Usuario usuario) throws Exception;

    List<Mascota> listarMascotasDeUsuario(Long usuarioId)throws Exception;

}













