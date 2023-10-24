/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hdemo2.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


/**
 *
 * @author gr0v3r
 */
public class HibernateUtil {
    private static StandardServiceRegistry register;
    private static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null) {
            try {
                register = new StandardServiceRegistryBuilder().configure().build();
                MetadataSources sources = new MetadataSources(register);
                Metadata metadata = sources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();
                
            } catch (Exception e) {
                e.printStackTrace();
                if(register != null){
                    StandardServiceRegistryBuilder.destroy(register);
                }
            }
        }
        return sessionFactory;
    }
}
