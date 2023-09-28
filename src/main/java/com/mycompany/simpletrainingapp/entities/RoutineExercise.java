/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp.entities;

import com.mycompany.simpletrainingapp.embeddable.RepRange;
import com.mycompany.simpletrainingapp.embeddable.RoutineExerciseId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

/**
 *
 * @author papar
 */
@Entity
public class RoutineExercise {
    
    @EmbeddedId
    private RoutineExerciseId id;
    private RepRange expectedRepRange;
    private int expectedWeight;

    public RoutineExercise() {}

    public RoutineExercise(RoutineExerciseId id, RepRange expectedRepRange, int expectedWeight) {
        this.id = id;
        this.expectedRepRange = expectedRepRange;
        this.expectedWeight = expectedWeight;
    }

    public DayRoutine getRoutine() {
        return id.getRoutine();
    }
    
    public Exercise getExercise() {
        return id.getExercise();
    }

    public RepRange getExpectedRepRange() {
        return expectedRepRange;
    }

    public void setExpectedRepRange(RepRange expectedRepRange) {
        this.expectedRepRange = expectedRepRange;
    }

    public int getExpectedWeight() {
        return expectedWeight;
    }

    public void setExpectedWeight(int expectedWeight) {
        this.expectedWeight = expectedWeight;
    }
    
    
    
    

}
