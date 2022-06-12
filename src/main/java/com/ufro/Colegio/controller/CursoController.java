package com.ufro.Colegio.controller;

import com.ufro.Colegio.model.Curso;
import com.ufro.Colegio.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CursoController {

    @Autowired
    CursoRepository cursoRepository;
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
}
