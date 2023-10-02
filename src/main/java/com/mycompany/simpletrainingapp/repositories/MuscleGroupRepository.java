/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp.repositories;

import com.mycompany.simpletrainingapp.entities.MuscleGroup;
import org.hibernate.Session;

/**
 *
 * @author papar
 */
public class MuscleGroupRepository {
    
    public MuscleGroup createMuscleGroup(String name){
        MuscleGroup muscleGroup = new MuscleGroup(name);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(muscleGroup);
            session.getTransaction().commit();
        }
        return muscleGroup;
    }
}
