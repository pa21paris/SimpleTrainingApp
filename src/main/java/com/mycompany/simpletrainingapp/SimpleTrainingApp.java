/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.simpletrainingapp;

import com.mycompany.simpletrainingapp.entities.MuscleGroup;
import com.mycompany.simpletrainingapp.repositories.HibernateUtil;
import com.mycompany.simpletrainingapp.repositories.MuscleGroupRepository;

/**
 *
 * @author papar
 */
public class SimpleTrainingApp {
    public static void main(String[] args) {
        HibernateUtil.startActivity();
        MuscleGroupRepository mgr = new MuscleGroupRepository();
        MuscleGroup mg = mgr.getMuscleGroups().toArray(new MuscleGroup[0])[0];
        MuscleGroup mg2 = mgr.getMuscleGroupByName(mg.getName());
        HibernateUtil.endActivity();
    }
}
