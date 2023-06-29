package pe.cib.rimbeiro.security.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.cib.rimbeiro.security.excepciones.RolNotFoundException;
import pe.cib.rimbeiro.security.model.Rol;
import pe.cib.rimbeiro.security.repository.RolRepository;
import pe.cib.rimbeiro.security.service.RolService;

import java.util.List;

@Service
@AllArgsConstructor
public class RolServiceImpl implements RolService {

    private RolRepository repository;

    @Override
    public Rol guardarRol(Rol rol) {
        return repository.save(rol);
    }

    @Override
    public Rol obtenerRolPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RolNotFoundException("el rol no existe"));
    }

    @Override
    public List<Rol> listarRoles() {
        return repository.findAll();
    }

    @Override
    public void eliminarRol(Long id) {
        repository.deleteById(id);
    }
}
