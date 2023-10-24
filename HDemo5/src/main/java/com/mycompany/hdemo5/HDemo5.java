/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hdemo5;

import com.mycompany.hdemo5.dao.CursosDao;
import com.mycompany.hdemo5.dao.InstructorDao;
import com.mycompany.hdemo5.entity.Cursos;
import com.mycompany.hdemo5.entity.Instructor;
import com.mycompany.hdemo5.entity.InstructorDetail;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gr0v3r
 */
public class HDemo5 {

    public static void main(String[] args) {
        Instructor instructor = new Instructor("carlos", "molina");
        
        InstructorDetail instrunctorDetail = new InstructorDetail("url_facebook", "jugar futbol");
        
        instructor.setInstructorDetail(instrunctorDetail);
        
        List<Cursos> cursos = new ArrayList<>();
        
        Cursos tempCurso1=new Cursos("matematicas");
        
        tempCurso1.setInstruntor(instructor);        
        cursos.add(tempCurso1);
        
        Cursos tempCurso2= new Cursos("algebra");
        tempCurso2.setInstruntor(instructor);
        cursos.add(tempCurso2);
        
        instructor.setCursos(cursos);
        
        InstructorDao instruntorDao= new InstructorDao();
        
        instruntorDao.saveInstructor(instructor);
    }
}
