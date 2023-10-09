/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp.entities;

import com.mycompany.simpletrainingapp.embeddable.RepRange;
import com.mycompany.simpletrainingapp.embeddable.RoutineExerciseId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import java.util.Objects;
import org.hibernate.annotations.Check;

/**
 *
 * @author papar
 */
@Entity
public class RoutineExercise {
    
    @EmbeddedId
    private RoutineExerciseId id;
    private RepRange expectedRepRange;
    @Check(name = "validExpectedWeight", constraints = "expectedWeight > 0")
    private int expectedWeight;
    @Check(name = "validExpectedSets", constraints = "expectedSets > 0")
    private int expectedSets;

    RoutineExercise() {}

    RoutineExercise(
            RoutineExerciseId id, RepRange expectedRepRange, int expectedWeight, int expectedSets
    ) {
        this.id = id;
        this.expectedRepRange = expectedRepRange;
        this.expectedWeight = expectedWeight;
        this.expectedSets = expectedSets;
    }
    
    RoutineExercise(RoutineExerciseId id) {
        this.id = id;
    }

    public Exercise getExercise() {
        return id.getExercise();
    }

    public Routine getRoutine() {
        return id.getRoutine();
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

    public int getExpectedSets() {
        return expectedSets;
    }

    public void setExpectedSets(int expectedSets) {
        this.expectedSets = expectedSets;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
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
        final RoutineExercise other = (RoutineExercise) obj;
        return Objects.equals(this.id, other.id);
    }
    
}
