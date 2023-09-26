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
public class MuscleGroup {
    
    @Id
    private String name;
    private Set<Muscle> muscles = new HashSet<>();
    
    private MuscleGroup(){}
    
    public MuscleGroup(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Muscle> getMuscles() {
        return Set.copyOf(muscles);
    }
    
    public boolean addMuscle(Muscle muscle){
        return this.muscles.add(muscle);
    }
    
    public boolean removeMuscle(Muscle muscle){
        return this.muscles.remove(muscle);
    }
    
}
