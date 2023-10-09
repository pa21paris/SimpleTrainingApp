/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author papar
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static Session session;
    
    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    
    public static boolean startActivity(){
        if((session != null) && session.isOpen()) return false;
        session = sessionFactory.openSession();
        return true;
    }
    
    public static boolean endActivity(){
        if(session == null) return false;
        if(!session.isOpen()) return false;
        session.close();
        return true;
    }
    
    protected static Session getSession(){
        return session;
    }
    
}
