/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hdemo5.dao;

import com.mycompany.hdemo5.entity.Cursos;
import com.mycompany.hdemo5.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author gr0v3r
 */
public class CursosDao {
    public void saveCurso(Cursos curso){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            
            transaction = session.beginTransaction();
            
            session.save(curso);
            
            transaction.commit();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
