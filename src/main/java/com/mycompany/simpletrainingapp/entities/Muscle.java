/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author papar
 */
@Entity
public class Muscle {
    
    @Id
    private String name;
    private MuscleGroup muscleGroup;
    private Set<Exercise> exercises = new HashSet<>();
    
    private Muscle(){}
    
    public Muscle(String name, MuscleGroup muscleGroup){
        this.name = name;
        this.muscleGroup = muscleGroup;
    }

    public String getName() {
        return name;
    }

    public MuscleGroup getMuscleGroup() {
        return muscleGroup;
    }
    
    public void setMuscleGroup(MuscleGroup muscleGroup){
        this.muscleGroup = muscleGroup;
    }

    public Set<Exercise> getExercises() {
        return Set.copyOf(exercises);
    }
    
    public boolean addExercise(Exercise exercise){
        return this.exercises.add(exercise);
    }
    
    public boolean removeExercise(Exercise exercise){
        return this.exercises.remove(exercise);
    }
    
}
