/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp.repositories;

import com.mycompany.simpletrainingapp.entities.MuscleGroup;
import java.util.List;
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
    
    public List<MuscleGroup> getMuscleGroups(){
        List<MuscleGroup> res;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            res = session
                    .createSelectionQuery("from MuscleGroup", MuscleGroup.class)
                    .getResultList();
        }
        return res;
    }
    
    public MuscleGroup getMuscleGroupByName(String name){
        MuscleGroup queryResult;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            queryResult = session.find(MuscleGroup.class, name);
        }
        return queryResult;
    }
    
   public void deleteMuscleGroup(MuscleGroup muscleGroup){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.remove(muscleGroup);
            session.getTransaction().commit();
        }
   }
}
