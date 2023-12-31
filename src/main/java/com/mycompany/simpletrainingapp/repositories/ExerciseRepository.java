/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp.repositories;

import com.mycompany.simpletrainingapp.entities.Exercise;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author papar
 */
public class ExerciseRepository {
    
    private Session session;
    
    public ExerciseRepository(){
        session = HibernateUtil.getSession();
    }
    
    public void saveExercise(Exercise exercise){
        session.beginTransaction();
        session.persist(exercise);
        session.getTransaction().commit();
    }
    
    public List<Exercise> getExercises(){
        return session
                .createSelectionQuery("from Exercise", Exercise.class)
                .getResultList();
    }
    
    public Exercise getExerciseByName(String name){
        return session
                .createQuery("from Exercise where name = :nameValue", Exercise.class)
                .setParameter("nameValue", name)
                .getSingleResultOrNull();
    }
    
    public void deleteExercise(Exercise exercise){
        session.beginTransaction();
        session.remove(exercise);
        session.getTransaction().commit();
    }
    
}
