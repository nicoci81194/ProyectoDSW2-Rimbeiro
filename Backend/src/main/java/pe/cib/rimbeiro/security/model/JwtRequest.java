package pe.cib.rimbeiro.security.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JwtRequest {

    private String username;
    private String password;

    public JwtRequest(){

    }

    public JwtRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
