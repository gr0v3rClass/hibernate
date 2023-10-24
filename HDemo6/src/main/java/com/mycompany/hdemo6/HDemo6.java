/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hdemo6;

import com.mycompany.hdemo6.dao.EstudianteDao;
import com.mycompany.hdemo6.entity.Estudiante;

/**
 *
 * @author gr0v3r
 */
public class HDemo6 {

    public static void main(String[] args) {
        EstudianteDao estudianteDao = new EstudianteDao();
        Estudiante estudiante = new Estudiante("ana", "calle", "ana@correo.com");
        
        estudianteDao.saveEstudiante(estudiante);
        
        estudianteDao.insertEstudiante();
    }
}
