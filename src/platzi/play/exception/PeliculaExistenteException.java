package platzi.play.exception;

public class PeliculaExistenteException extends RuntimeException{
    public PeliculaExistenteException (String titulo){
        super("ERROR: La película " + titulo + " ya existe!");
    }
}
