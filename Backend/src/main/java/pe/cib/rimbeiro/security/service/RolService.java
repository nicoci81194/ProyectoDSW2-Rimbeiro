package pe.cib.rimbeiro.security.service;

import pe.cib.rimbeiro.security.model.Rol;

import java.util.List;

public interface RolService {
    Rol guardarRol(Rol rol);
    Rol obtenerRolPorId(Long id);
    List<Rol> listarRoles();
    void eliminarRol(Long id);


}
