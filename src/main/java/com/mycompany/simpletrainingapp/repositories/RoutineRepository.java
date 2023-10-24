/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp.repositories;

import com.mycompany.simpletrainingapp.entities.Routine;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author papar
 */
public class RoutineRepository {
    
    private Session session;
    
        
    public RoutineRepository(){
        session = HibernateUtil.getSession();
    }
    
    public void saveRoutine(Routine routine){
        session.beginTransaction();
        session.persist(routine);
        session.getTransaction().commit();
    }
    
    public List<Routine> getRoutines(){
        return session
                .createSelectionQuery("from Routine", Routine.class)
                .getResultList();
    }
    
    public List<Routine> getRoutinesByName(String name){
        return session
                .createQuery("from Routine where upper(name) like upper(:nameValue)", Routine.class)
                .setParameter("nameValue", "%"+name+"%")
                .getResultList();
    }
    
    public void deleteRoutine(Routine routine){
        session.beginTransaction();
        session.remove(routine);
        session.getTransaction().commit();
    }
    
}
