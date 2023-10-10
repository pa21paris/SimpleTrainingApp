/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp.repositories;

import com.mycompany.simpletrainingapp.entities.Muscle;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author papar
 */
public class MuscleRepository {
    
    private Session session;

    public MuscleRepository() {
        this.session = HibernateUtil.getSession();
    }
    
    public void saveMuscle(Muscle muscle){
        session.beginTransaction();
        session.persist(muscle);
        session.getTransaction().commit();
    }
    
    public List<Muscle> getMuscles(){
        return session
                .createSelectionQuery("from Muscle", Muscle.class)
                .getResultList();
    } 
    
    public Muscle getMuscleByName(String name){
        return session
                .find(Muscle.class, name);
    }
    
    public void deleteMuscle(Muscle muscle){
        var muscleGroup = muscle.getMuscleGroup();
        session.beginTransaction();
        muscleGroup.removeMuscle(muscle);
        session.getTransaction().commit();
    }
    
}
