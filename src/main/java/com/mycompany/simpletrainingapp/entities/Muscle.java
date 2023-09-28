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
    private final Set<Exercise> targetedExercises = new HashSet<>();
    private final Set<Exercise> synergistExercises = new HashSet<>();
    
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

    public Set<Exercise> getTargetedExercises() {
        return Set.copyOf(this.targetedExercises);
    }
    
    public boolean addTargetedExercise(Exercise exercise){
        return this.targetedExercises.add(exercise);
    }
    
    public boolean removeTargetedExercise(Exercise exercise){
        return this.targetedExercises.remove(exercise);
    }
    
    public Set<Exercise> getSynergistExercises() {
        return Set.copyOf(this.synergistExercises);
    }
    
    public boolean addSynergistExercise(Exercise exercise){
        return this.synergistExercises.add(exercise);
    }
    
    public boolean removeSynergistExercise(Exercise exercise){
        return this.synergistExercises.remove(exercise);
    }
    
    public Set<Exercise> getAllExercises(){
        var res = new HashSet<Exercise>();
        res.addAll(this.getTargetedExercises());
        res.addAll(this.getSynergistExercises());
        return res;
    }
    
}
