package es.daw.altausuariosprinh.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ficheroNoEncontradoException.class)
    public String gestionarErrorFichero(ficheroNoEncontradoException error, Model model) {
        model.addAttribute("mensajeError", error.getMessage());
        return "error";
    }
}