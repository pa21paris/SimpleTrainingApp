/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author papar
 */
@Entity
public class Muscle {
    
    @Id @Column(length = 60)
    private String name;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private MuscleGroup muscleGroup;
    @OneToMany(
            mappedBy = "targetMuscle", 
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, 
            orphanRemoval = true
    )
    private final Set<Exercise> targetedExercises = new HashSet<>();
    
    Muscle(){}
    
    public Muscle(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public MuscleGroup getMuscleGroup() {
        return muscleGroup;
    }
    
    void setMuscleGroup(MuscleGroup muscleGroup){
        this.muscleGroup = muscleGroup;
    }

    public Set<Exercise> getTargetedExercises() {
        return Set.copyOf(this.targetedExercises);
    }
    
    public boolean addTargetedExercise(Exercise exercise){
        exercise.setTargetMuscle(this);
        return this.targetedExercises.add(exercise);
    }
    
    public boolean removeTargetedExercise(Exercise exercise){
        exercise.setTargetMuscle(null);
        return this.targetedExercises.remove(exercise);
    }

    @Override
    public String toString() {
        return "Muscle{" + "name=" + name + '}';
    }
    
}
