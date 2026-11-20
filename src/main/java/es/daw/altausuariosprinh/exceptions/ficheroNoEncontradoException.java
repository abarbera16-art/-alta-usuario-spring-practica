package es.daw.altausuariosprinh.exceptions;

public class ficheroNoEncontradoException extends RuntimeException {
    public ficheroNoEncontradoException(String message) {
        super(message);
    }

    public ficheroNoEncontradoException(String message,Throwable cause){
        super(message, cause);
    }
}
