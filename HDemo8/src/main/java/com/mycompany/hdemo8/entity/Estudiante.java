/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hdemo8.entity;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author gr0v3r
 */
@Entity
@Table(name = "estudicnate")
public class Estudiante {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private int idEstudiante;
    
    @Column(name = "nombre")
    private String nomnre;
    
    @ManyToMany
    @JoinTable(
    name = "estudiante_curso",
           joinColumns = @JoinColumn(name = "id_estudiante"),
           inverseJoinColumns = @JoinColumn(name = "id_curso")
    )
    private Set<Curso> cursos; 
}
