package com.ufro.Colegio.controller;

import com.ufro.Colegio.model.Alumno;
import com.ufro.Colegio.model.Curso;
import com.ufro.Colegio.repository.AlumnoRepository;
import com.ufro.Colegio.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class CursoController {

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    AlumnoRepository alumnoRepository;

    @RequestMapping("/registrar-curso")
    public String registrarCurso(){
        return "registrarCurso";
    }

    @PostMapping("/registrar-curso/nuevo-curso")
    public String nuevoCurso(@ModelAttribute Curso curso){
        cursoRepository.save(curso);
        return "redirect:/";
    }
    @RequestMapping("/ver-cursos")
    public String verCursos(Model model){
        model.addAttribute("cursos", cursoRepository.findAll());
        return "verCursos";
    }

    @GetMapping("/ver-curso")
    public String verCurso(@RequestParam(value="id") Long id, Model model){
        Optional<Curso> curso=cursoRepository.findById(id);
        model.addAttribute("curso",curso.orElseThrow());
        model.addAttribute("alumnos", alumnoRepository.findAllByCursoId(id));
        return "verCurso";
    }
}
