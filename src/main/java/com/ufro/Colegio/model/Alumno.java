package com.ufro.Colegio.model;

import javax.persistence.*;

@Entity
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "matricula", nullable = false, length = 15 )
    private String matricula;

    @Column(name = "Nombre", nullable = false, length = 150 )
    private String nombre;

    @Column(name = "imagen", nullable = false)
    private String imagen;

    @Column(name = "Apoderado", nullable = false, length = 100)
    private String apoderado;

    @Column(name = "telefono", nullable = false, length = 13)
    private String telefono;

    @ManyToOne
    @JoinColumn(name="curso_id")
    private Curso curso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getApoderado() {
        return apoderado;
    }

    public void setApoderado(String apoderado) {
        this.apoderado = apoderado;
    }
}
