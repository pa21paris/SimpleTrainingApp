/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp.embeddable;

import com.mycompany.simpletrainingapp.entities.RoutineExercise;
import jakarta.persistence.Embeddable;
import java.time.LocalDate;
import org.hibernate.annotations.Check;

/**
 *
 * @author papar
 */
@Embeddable
@Check(name = "validSetNumber", constraints = "set > 0")
public class SetRecordId {
    
    private RoutineExercise routineExercise;
    private LocalDate date;
    private int set;

    public SetRecordId() {}

    public SetRecordId(RoutineExercise routineExercise, LocalDate date, int set) {
        this.routineExercise = routineExercise;
        this.date = date;
        this.set = set;
    }

    public RoutineExercise getRoutineExercise() {
        return routineExercise;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getSet() {
        return set;
    }    
    
}
