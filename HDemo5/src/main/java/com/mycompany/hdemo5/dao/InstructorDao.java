/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hdemo5.dao;

import com.mycompany.hdemo5.entity.Instructor;
import com.mycompany.hdemo5.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author gr0v3r
 */
public class InstructorDao {
    public void saveInstructor(Instructor instructor){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            
            transaction = session.beginTransaction();
            
            session.save(instructor);
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public Instructor getInstructor(int id){
        Transaction transaction = null;
        Instructor instrunctor = null;
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            
            transaction = session.beginTransaction();
            
            instrunctor = session.get(Instructor.class, id);
            
            transaction.commit();
            
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        
        return  instrunctor;
    }
    
    public void updateInstrunctor(Instructor instruntor){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            
            session.update(instruntor);
            
            transaction.commit();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void deleteInstruntor(int id){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            
            Instructor instructor = session.get(Instructor.class, id);
            if (instructor != null) {
                session.delete(instructor);
                System.out.println("Instruntor eliminado");
            }
            
            transaction.commit();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
