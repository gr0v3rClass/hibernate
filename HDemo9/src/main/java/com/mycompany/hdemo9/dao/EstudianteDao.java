/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hdemo9.dao;

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
public class EstudianteDao {

    public void saveEstudiante(Estudiante estudiante) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
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

    public void insertEstudiante(String nombre, int telefono) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String hql = " INSER INTO estudiante (nombre, telefono) value (:nomEstudiante, : telEstudiante)";

            Query query = session.createQuery(hql);
            query.setParameter("nomEstudiante", nombre);
            query.setParameter("telEstudiante", telefono);
            
            query.executeUpdate();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateEstudiante(Estudiante estudiante) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String hql = " UPDATE estudiante SET nombre = : nomEstudiante WHERE id = :idEstudiante";

            Query query = session.createQuery(hql);
            query.setParameter("nomEstudiante", estudiante.getNombre());
            query.setParameter("idEstudiante", estudiante.getId());
            int result = query.executeUpdate();

            System.out.println("filas afectadas:  " + result);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteEstudiante(int id) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Estudiante estudiante = session.get(Estudiante.class, id);

            if (estudiante != null) {
                String hql = " DELETE FROM estudiante WHERE id = :idEstudiante";

                Query query = session.createQuery(hql);
                query.setParameter("idEstudiante", id);
                int result = query.executeUpdate();

                System.out.println("filas afectadas:  " + result);
            }

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Estudiante getEstudiante(int id) {

        Transaction transaction = null;
        Estudiante estudiante = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String hql = " FROM estudiante e WHERE e.id = :estudianteId";

            Query query = session.createQuery(hql);
            query.setParameter("estudianteId", id);
            List results = query.getResultList();

            if (results != null && !results.isEmpty()) {
                estudiante = (Estudiante) results.get(0);
            }
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return estudiante;
    }
}
