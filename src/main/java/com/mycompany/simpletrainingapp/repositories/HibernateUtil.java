/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp.repositories;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author papar
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    
    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    
    protected static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
