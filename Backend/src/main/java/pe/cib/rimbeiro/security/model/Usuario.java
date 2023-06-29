package pe.cib.rimbeiro.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pe.cib.rimbeiro.model.Mascota;
import pe.cib.rimbeiro.security.config.GrantedAuthorityDeserializer;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



@Entity
@Data
@Table(name = "tb_usuario")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 200, message = "El nombre debe tener entre 5 y 200 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 3, max = 200, message = "El apellido debe tener entre 5 y 200 caracteres")
    private String apellido;
    @Column(unique = true)
    @Email(message = "Ingrese una dirección de correo electrónico válida")
    private String email;
    @Pattern(regexp = "\\d{9}", message = "Ingrese un número de teléfono válido de 10 dígitos")
    private String telefono;
    private boolean enabled = true;

    @JsonDeserialize(using = GrantedAuthorityDeserializer.class)
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER ,mappedBy = "usuario")
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();

    //  -   -   -   -   -   -   -   -   -   -   -

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Mascota> mascotas;

    public Usuario(){

    }

    public Usuario(Long id, String username, String password, String nombre, String apellido, String email, String telefono, boolean enabled/*, String perfil*/) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.enabled = enabled;
        //this.perfil = perfil;
    }


    @Override
    @JsonDeserialize(using = GrantedAuthorityDeserializer.class) /*Modificacion - Gianluc*/
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> autoridades = new HashSet<>();
        this.usuarioRoles.forEach(usuarioRol -> {
            autoridades.add(new Authority(usuarioRol.getRol().getDescripcion()));
        });
        return autoridades;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}