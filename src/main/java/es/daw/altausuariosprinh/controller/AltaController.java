package es.daw.altausuariosprinh.controller;

import es.daw.altausuariosprinh.service.OpcionesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AltaController {

    private final OpcionesService opcionesService;

    public AltaController(OpcionesService opcionesService) {
        this.opcionesService = opcionesService;
    }

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/alta")
    public String mostrarFormulario(Model model) {
        model.addAttribute("tecnologias", opcionesService.getTecnologias());
        model.addAttribute("listaNiveles", opcionesService.getNiveles());
        return "formulario";
    }

    @PostMapping("/alta")
    public String procesarFormulario(@RequestParam String nombre,
                                     @RequestParam String email,
                                     @RequestParam String tecnologia,
                                     @RequestParam(name = "nivel", required = false) List<String> niveles,
                                     Model model) {

        List<String> nivelesSeguros = (niveles != null) ? niveles : List.of();

        if (nombre == null || nombre.isBlank()) {
            model.addAttribute("mensajeError", "El nombre es obligatorio.");
            model.addAttribute("nombre", nombre);
            model.addAttribute("email", email);
            model.addAttribute("tecnologia", tecnologia);
            model.addAttribute("niveles", nivelesSeguros);

            // Volvemos a cargar las listas para que los desplegables no salgan vacíos
            model.addAttribute("tecnologias", opcionesService.getTecnologias());
            model.addAttribute("listaNiveles", opcionesService.getNiveles());
            return "formulario";
        }

        model.addAttribute("nombre", nombre);
        model.addAttribute("email", email);
        model.addAttribute("tecnologia", tecnologia);
        model.addAttribute("niveles", nivelesSeguros);
        return "confirmacion";
    }
}