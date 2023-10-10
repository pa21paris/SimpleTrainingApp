/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.simpletrainingapp;

import com.mycompany.simpletrainingapp.entities.Muscle;
import com.mycompany.simpletrainingapp.entities.MuscleGroup;
import com.mycompany.simpletrainingapp.repositories.HibernateUtil;
import com.mycompany.simpletrainingapp.repositories.MuscleGroupRepository;
import com.mycompany.simpletrainingapp.repositories.MuscleRepository;

/**
 *
 * @author papar
 */
public class SimpleTrainingApp {
    public static void main(String[] args) {
        HibernateUtil.startActivity();
        var muscle = new Muscle("Pepe");
        var muscleGroup = new MuscleGroup("PepeGroup");
        muscleGroup.addMuscle(muscle);
        var mgr = new MuscleGroupRepository();
        mgr.saveMuscleGroup(muscleGroup);
        muscleGroup.removeMuscle(muscle);
        var mr = new MuscleRepository();
        mr.deleteMuscle(muscle);
        HibernateUtil.endActivity();
    }
}
