package com.mycompany.hdemo10.dao;


import com.mycompany.hdemo10.entity.Estudiante;
import com.mycompany.hdemo10.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gr0v3r
 */
public class EstudianteDao {
    public void saveEstudiante(Estudiante estudiante){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            
            session.save(estudiante);
            
            transaction.commit();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
