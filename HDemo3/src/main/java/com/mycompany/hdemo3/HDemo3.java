/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hdemo3;

import com.mycompany.hdemo3.entity.Persona;
import com.mycompany.hdemo3.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author gr0v3r
 */
public class HDemo3 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Persona persona = new Persona("carlos", "molina", "11222121212");
        //saveOrUpdatePersonona(persona);
        savePErsona(persona);
        deletePersona();
    }
    
    public static void saveOrUpdatePersonona(Persona persona){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            //session.saveOrUpdate(persona);
            
            Persona persona2 = session.get(Persona.class, 2);
            
            persona2.setNombre("pablito");
            
            session.saveOrUpdate(persona2);
            
            
            transaction.commit();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public static void savePErsona(Persona persona){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(persona);
            
            transaction.commit();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public static void deletePersona(){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            //session.saveOrUpdate(persona);
            
            Persona persona2 = session.get(Persona.class, 2);
            
            if (persona2 != null) {
                session.delete(persona2);
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
