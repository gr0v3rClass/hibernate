/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hdemo4;

import com.mycompany.hdemo4.dao.InstructorDao;
import com.mycompany.hdemo4.entity.Instructor;
import com.mycompany.hdemo4.entity.InstructorDetail;

/**
 *
 * @author gr0v3r
 */
public class HDemo4 {

    public static void main(String[] args) {
        InstructorDao instructorDao = new InstructorDao();
        // insertar
        /*    Instructor instructor = new Instructor("carol", "arenas");
            InstructorDetail instructorDetail = new InstructorDetail("url_facebook", "raquet");
            instructor.setInstructorDetail(instructorDetail);
            instructorDao.saveInstructor(instructor);
        */
        // traer informacion 
        
        /*Instructor instruntor = new Instructor();
        
        instruntor = instructorDao.getInstructor(2);
        
        System.out.println("data"+ instruntor.toString());*/
        
        
        // actualizar informacion
        
        /*instruntor.setFirstName("Rogelio");
        
        instructorDao.updateInstrunctor(instruntor);*/
        
        // eliminar
        
        instructorDao.deleteInstruntor(2);
    }
}
