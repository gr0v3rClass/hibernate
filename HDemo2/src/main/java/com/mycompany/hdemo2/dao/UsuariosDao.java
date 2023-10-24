/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hdemo2.dao;

import com.mycompany.hdemo2.entity.Usuarios;
import com.mycompany.hdemo2.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author gr0v3r
 */
public class UsuariosDao {
    
    public void saveUsuario (Usuarios usuario){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public List<Usuarios> getUsuarios(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Usuarios", Usuarios.class).list();
        }
    }
}
