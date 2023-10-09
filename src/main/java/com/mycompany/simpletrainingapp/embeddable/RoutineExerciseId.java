/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp.embeddable;

import com.mycompany.simpletrainingapp.entities.Routine;
import com.mycompany.simpletrainingapp.entities.Exercise;
import jakarta.persistence.Basic;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import java.time.DayOfWeek;
import java.util.Objects;

/**
 *
 * @author papar
 */
@Embeddable
public class RoutineExerciseId {
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Routine routine;
    @ManyToOne(fetch = FetchType.LAZY)
    private Exercise exercise;
    @Enumerated
    @Basic(optional = false)
    private DayOfWeek dayOfWeek;

    RoutineExerciseId() {}

    public RoutineExerciseId(Routine routine, Exercise exercise, DayOfWeek day) {
        this.routine = routine;
        this.exercise = exercise;
        this.dayOfWeek = day;
    }

    public Routine getRoutine() {
        return routine;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.routine);
        hash = 47 * hash + Objects.hashCode(this.exercise);
        hash = 47 * hash + Objects.hashCode(this.dayOfWeek);
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
        final RoutineExerciseId other = (RoutineExerciseId) obj;
        if (!Objects.equals(this.routine, other.routine)) {
            return false;
        }
        if (!Objects.equals(this.exercise, other.exercise)) {
            return false;
        }
        return this.dayOfWeek == other.dayOfWeek;
    }
    
}
