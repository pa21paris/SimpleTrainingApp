/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp.entities;

import com.mycompany.simpletrainingapp.embeddable.RepRange;
import com.mycompany.simpletrainingapp.embeddable.RoutineExerciseId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author papar
 */
@Entity
public class DayRoutine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(unique = true, length = 60)
    private String name;
    
    @OneToMany(mappedBy = "id.routine")
    private Set<RoutineExercise> exercises = new HashSet<>();

    public DayRoutine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<RoutineExercise> getExercises() {
        return Set.copyOf(exercises);
    }

    public boolean addExercise(Exercise exercise, RepRange repRange, int weight, int sets) {
        var routineExerciseId = new RoutineExerciseId(this, exercise);
        return this.exercises.add(new RoutineExercise(
                routineExerciseId,
                repRange,
                weight,
                sets
        ));
    }
    
    public boolean removeExercise(Exercise exercise){
        return this.exercises.removeIf(e -> e.getExercise() == exercise);
    }
    
    public boolean modifyExercise(Exercise exercise, RepRange repRange, int weight, int sets){
        boolean changed = false;
        for(RoutineExercise e : this.exercises){
            if(e.getExercise() == exercise){
                e.setExpectedRepRange(repRange);
                e.setExpectedWeight(weight);
                e.setExpectedSets(sets);
                changed = true;
            }
        }
        return changed;
    }
    
    public boolean modifyExerciseReps(Exercise exercise, RepRange repRange){
        boolean changed = false;
        for(RoutineExercise e : this.exercises){
            if(e.getExercise() == exercise){
                e.setExpectedRepRange(repRange);
                changed = true;
            }
        }
        return changed;
    }
    
    public boolean modifyExerciseWeight(Exercise exercise, int weight){
        boolean changed = false;
        for(RoutineExercise e : this.exercises){
            if(e.getExercise() == exercise){
                e.setExpectedWeight(weight);
                changed = true;
            }
        }
        return changed;
    }

    public boolean modifyExerciseSets(Exercise exercise, int sets){
        boolean changed = false;
        for(RoutineExercise e : this.exercises){
            if(e.getExercise() == exercise){
                e.setExpectedSets(sets);
                changed = true;
            }
        }
        return changed;
    }
}
