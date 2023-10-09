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

    public MuscleGroup createMuscleGroup(String name) throws ConstraintViolationException {
        MuscleGroup muscleGroup = new MuscleGroup(name);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(muscleGroup);
        session.getTransaction().commit();
        return muscleGroup;
    }

    public List<MuscleGroup> getMuscleGroups() {
        List<MuscleGroup> res;
        Session session = HibernateUtil.getSession();
        res = session
                .createSelectionQuery("from MuscleGroup", MuscleGroup.class)
                .getResultList();
        return res;
    }

    public MuscleGroup getMuscleGroupByName(String name) {
        MuscleGroup queryResult;
        Session session = HibernateUtil.getSession();
        queryResult = session.find(MuscleGroup.class, name);
        return queryResult;
    }

    public void deleteMuscleGroup(MuscleGroup muscleGroup) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(muscleGroup);
        session.getTransaction().commit();
    }
}
