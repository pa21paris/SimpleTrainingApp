/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp.embeddable;

import com.mycompany.simpletrainingapp.entities.DayRoutine;
import com.mycompany.simpletrainingapp.entities.Exercise;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author papar
 */
@Embeddable
public class RoutineExerciseId {
    
    @ManyToOne(fetch = FetchType.LAZY)
    private DayRoutine routine;
    @ManyToOne(fetch = FetchType.LAZY)
    private Exercise exercise;

    private RoutineExerciseId() {}

    public RoutineExerciseId(DayRoutine routine, Exercise exercise) {
        this.routine = routine;
        this.exercise = exercise;
    }

    public DayRoutine getRoutine() {
        return routine;
    }

    public Exercise getExercise() {
        return exercise;
    }    
    
}
