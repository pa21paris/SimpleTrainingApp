/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author papar
 */
@Entity
public class MuscleGroup {
    
    @Id @Column(length = 60)
    private String name;
    @OneToMany(mappedBy = "muscleGroup", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private final Set<Muscle> muscles = new HashSet<>();
    
    MuscleGroup(){}
    
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
        muscle.setMuscleGroup(this);
        return this.muscles.add(muscle);
    }
    
    public boolean removeMuscle(Muscle muscle){
        muscle.setMuscleGroup(null);
        return this.muscles.remove(muscle);
    }
    
    public Set<Exercise> getTargetedExercises(){
        var res = new HashSet<Exercise>();
        for(Muscle m : this.getMuscles()) res.addAll(m.getTargetedExercises());
        return res;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MuscleGroup other = (MuscleGroup) obj;
        return Objects.equals(this.name, other.name);
    }
    
    
    
}
