/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp.embeddable;

import com.mycompany.simpletrainingapp.entities.Exercise;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Objects;
import org.hibernate.annotations.Check;

/**
 *
 * @author papar
 */
@Embeddable
public class SetRecordId {
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Exercise exercise;
    private LocalDate setDate;
    @Check(name = "validSetNumber", constraints = "setNumber > 0")
    private int setNumber;

    SetRecordId() {}

    public SetRecordId(Exercise exercise, LocalDate date, int set) {
        this.exercise = exercise;
        this.setDate = date;
        this.setNumber = set;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public LocalDate getDate() {
        return setDate;
    }

    public int getSet() {
        return setNumber;
    }    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.exercise);
        hash = 73 * hash + Objects.hashCode(this.setDate);
        hash = 73 * hash + this.setNumber;
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
        final SetRecordId other = (SetRecordId) obj;
        if (this.setNumber != other.setNumber) {
            return false;
        }
        if (!Objects.equals(this.exercise, other.exercise)) {
            return false;
        }
        return Objects.equals(this.setDate, other.setDate);
    }
    
    
    
}
