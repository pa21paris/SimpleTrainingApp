/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp.embeddable;

import com.mycompany.simpletrainingapp.entities.RoutineExercise;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import org.hibernate.annotations.Check;

/**
 *
 * @author papar
 */
@Embeddable
public class SetRecordId {
    
    @ManyToOne(fetch = FetchType.LAZY)
    private RoutineExercise routineExercise;
    private LocalDate setDate;
    @Check(name = "validSetNumber", constraints = "setNumber > 0")
    private int setNumber;

    public SetRecordId() {}

    public SetRecordId(RoutineExercise routineExercise, LocalDate date, int set) {
        this.routineExercise = routineExercise;
        this.setDate = date;
        this.setNumber = set;
    }

    public RoutineExercise getRoutineExercise() {
        return routineExercise;
    }

    public LocalDate getDate() {
        return setDate;
    }

    public int getSet() {
        return setNumber;
    }    
    
}
