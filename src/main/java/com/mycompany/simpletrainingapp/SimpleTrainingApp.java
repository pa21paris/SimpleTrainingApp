/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.simpletrainingapp;

import com.mycompany.simpletrainingapp.entities.MuscleGroup;
import com.mycompany.simpletrainingapp.repositories.MuscleGroupRepository;

/**
 *
 * @author papar
 */
public class SimpleTrainingApp {
    public static void main(String[] args) {
        MuscleGroupRepository mgr = new MuscleGroupRepository();
        MuscleGroup muscleGroup = mgr.getMuscleGroups().get(0);
        muscleGroup.getMuscles().forEach(muscle -> System.out.println(muscle.getName()));
        
    }
}
