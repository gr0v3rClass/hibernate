/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hdemo8;

import com.mycompany.hdemo8.dao.CursoDao;
import com.mycompany.hdemo8.dao.EstudianteDao;
import com.mycompany.hdemo8.entity.Curso;
import com.mycompany.hdemo8.entity.Estudiante;

/**
 *
 * @author gr0v3r
 */
public class HDemo8 {

    public static void main(String[] args) {
        
        Estudiante estudiante = new Estudiante("ana");
        Curso curso = new Curso("matematicas");
        CursoDao cursoDao = new CursoDao();
        cursoDao.saveCurso(curso);
        estudiante.getCursos().add(curso);
        EstudianteDao estudianteDao = new EstudianteDao();
        estudianteDao.saveEstudiante(estudiante);
        
    }
}
