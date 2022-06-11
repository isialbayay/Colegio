package com.ufro.Colegio.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "matricula" nullable = false, length = 15 )
    private String matricula;

    @Column(name = "Nombre", nullable = false, length = 150 )
    private String mensaje;

    @Column(name = "Nombre", nullable = false, length = 150 )
    private String mensaje;

    @Column(name = "Apoderado", nullable = false, length = 100)
    private String nombre;

    @Column(name = "telefono", nullable = false, length = 10)
    private String telefono;

    @ManyToOne
    @JoinColumn(name="curso_id")
    private Curso curso;
}
