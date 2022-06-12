package com.ufro.Colegio.controller;

import com.ufro.Colegio.model.Alumno;
import com.ufro.Colegio.model.Curso;
import com.ufro.Colegio.repository.AlumnoRepository;
import com.ufro.Colegio.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class AlumnoController {

    @Autowired
    AlumnoRepository alumnoRepository;

    @Autowired
    CursoRepository cursoRepository;

    @RequestMapping("/registrar-alumno")
    public String registrarAlumno(Model model){
        model.addAttribute("cursos", cursoRepository.findAll());
        return "registrarAlumno";
    }

    @PostMapping("/registrar-alumno/nuevo-alumno")
    public String nuevoAlumno(@ModelAttribute Alumno alumno){
        alumnoRepository.save(alumno);
        return "redirect:/";
    }

    @RequestMapping("/ver-alumnos")
    public String verCursos(Model model){
        model.addAttribute("alumnos", alumnoRepository.findAll());
        return "verAlumnos";
    }

    @GetMapping("/ver-alumno")
    public String verAlumno(@RequestParam(value="id") Long id, Model model){
        Optional<Alumno> alumno=alumnoRepository.findById(id);
        model.addAttribute("alumno",alumno.orElseThrow());
        return "verAlumno";
    }


}
