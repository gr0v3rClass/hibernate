/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hdemo10.beans;

import com.mycompany.hdemo10.dao.EstudianteDao;
import com.mycompany.hdemo10.entity.Estudiante;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;



/**
 *
 * @author gr0v3r
 */
@Named
@ViewScoped
public class indexBean implements Serializable{
    
    private String name;
    private String telefono;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void add(){
        
        Estudiante estudiante = new Estudiante();
        
        estudiante.setNombre(name);
        estudiante.setTelefono(Integer.parseInt(telefono));
        
        System.out.println("Estudiaante: " + estudiante.toString());
        
        EstudianteDao estudianteDao = new EstudianteDao();
        
        estudianteDao.saveEstudiante(estudiante);
    }
}
