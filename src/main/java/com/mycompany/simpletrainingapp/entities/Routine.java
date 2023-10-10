/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp.entities;

import com.mycompany.simpletrainingapp.embeddable.RepRange;
import com.mycompany.simpletrainingapp.embeddable.RoutineExerciseId;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author papar
 */
@Entity
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, length = 60, nullable = false)
    private String name;

    @OneToMany(
            mappedBy = "id.routine", 
            cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, 
            orphanRemoval = true
    )
    private Set<RoutineExercise> exercises = new HashSet<>();

    Routine() {
    }

    public Routine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<RoutineExercise> getExercises() {
        return Set.copyOf(this.exercises);
    }
        
    public boolean addExercise(
            Exercise exercise, RepRange repRange, int weight, int sets, DayOfWeek day
    ) {
        var routineExerciseId = new RoutineExerciseId(this, exercise, day);
        var routineExercise = new RoutineExercise(
                routineExerciseId,
                repRange,
                weight,
                sets
        );
        return this.exercises.add(routineExercise) && exercise.addRoutine(routineExercise);
        
    }

    public boolean removeExercise(Exercise exercise, DayOfWeek day) {
        var routineExercise = new RoutineExercise(new RoutineExerciseId(this, exercise, day));
        return this.exercises.remove(routineExercise) 
                && exercise.removeRoutine(routineExercise);
    }

    public boolean modifyExercise(Exercise exercise, RepRange repRange, int weight, int sets) {
        boolean changed = false;
        for (RoutineExercise e : this.exercises) {
            if (e.getExercise() == exercise) {
                e.setExpectedRepRange(repRange);
                e.setExpectedWeight(weight);
                e.setExpectedSets(sets);
                changed = true;
            }
        }
        return changed;
    }

    public boolean modifyExerciseReps(Exercise exercise, RepRange repRange) {
        boolean changed = false;
        for (RoutineExercise e : this.exercises) {
            if (e.getExercise() == exercise) {
                e.setExpectedRepRange(repRange);
                changed = true;
            }
        }
        return changed;
    }

    public boolean modifyExerciseWeight(Exercise exercise, int weight) {
        boolean changed = false;
        for (RoutineExercise e : this.exercises) {
            if (e.getExercise() == exercise) {
                e.setExpectedWeight(weight);
                changed = true;
            }
        }
        return changed;
    }

    public boolean modifyExerciseSets(Exercise exercise, int sets) {
        boolean changed = false;
        for (RoutineExercise e : this.exercises) {
            if (e.getExercise() == exercise) {
                e.setExpectedSets(sets);
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.name);
        return hash;
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
        final Routine other = (Routine) obj;
        return Objects.equals(this.name, other.name);
    }

}
