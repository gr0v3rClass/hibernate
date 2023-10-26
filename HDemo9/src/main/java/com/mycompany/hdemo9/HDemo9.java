/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hdemo9;

import com.mycompany.hdemo9.dao.EstudianteDao;
import com.mycompany.hdemo9.entity.Estudiante;
import com.mycompany.hdemo9.util.HibernateUtil;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author gr0v3r
 */
public class HDemo9 {

    public static void main(String[] args) {
        EstudianteDao estudianteDao = new EstudianteDao();
        
        Estudiante estudiante = new Estudiante();
        
        /*estudiante.setNombre("carlos");
        estudiante.setTelefono(22333221);
        
        estudianteDao.saveEstudiante(estudiante);
        
        estudiante.setNombre("ana");
        estudiante.setTelefono(454323);
        
        estudianteDao.saveEstudiante(estudiante);*/
        
        //estudiante = estudianteDao.getEstudiante(2);
        
        //System.out.println("Estudiante...   "+estudiante.toString());
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            
            List<Estudiante> estudiantes = session.createQuery(" FROM estudiante", Estudiante.class).list();
            
            
            
            estudiantes.forEach(s -> System.out.println("nombre: "+s.getNombre()));
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        
        
        
    }
}
