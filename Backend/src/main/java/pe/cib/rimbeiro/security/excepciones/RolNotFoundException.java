package pe.cib.rimbeiro.security.excepciones;

public class RolNotFoundException extends RuntimeException{

    /*public RolNotFoundException(){
        super("El rol especificado no existe");
    }*/

    public RolNotFoundException(String mensaje){
        super(mensaje);
    }
}
