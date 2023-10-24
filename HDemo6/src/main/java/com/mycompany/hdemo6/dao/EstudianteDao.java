/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hdemo6.dao;

import com.mycompany.hdemo6.entity.Estudiante;
import com.mycompany.hdemo6.util.HibernateUtil;
import java.io.Serializable;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author gr0v3r
 */
public class EstudianteDao {
    public void saveEstudiante( Estudiante estudiante){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Object object= session.save(estudiante);
            
            session.get(Estudiante.class, (Serializable) object);
            
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void insertEstudiante(){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            
            String hql = "INSERT INTO estudiante(first_name,last_name,email) VALUE ("aaa", "bbb", "cccc")";
            
            Query query = session.createQuery(hql);
            
            int result = query.executeUpdate();
            System.out.println("Rows affected"+ result);
            
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
