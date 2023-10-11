/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp.repositories;

import com.mycompany.simpletrainingapp.entities.MuscleGroup;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author papar
 */
public class MuscleGroupRepository {
    
    private Session session;
    
    public MuscleGroupRepository(){
        session = HibernateUtil.getSession();
    }

    public void saveMuscleGroup(MuscleGroup muscleGroup) throws ConstraintViolationException {
        session.beginTransaction();
        session.persist(muscleGroup);
        session.getTransaction().commit();
    }

    public List<MuscleGroup> getMuscleGroups() {
        var res = session
                .createSelectionQuery("from MuscleGroup", MuscleGroup.class)
                .getResultList();
        return res;
    }

    public MuscleGroup getMuscleGroupByName(String name) {
        return session.find(MuscleGroup.class, name);
    }

    public void deleteMuscleGroup(MuscleGroup muscleGroup) {
        session.beginTransaction();
        session.remove(muscleGroup);
        session.getTransaction().commit();
    }
}
