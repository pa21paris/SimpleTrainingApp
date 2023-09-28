/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.annotations.Check;

/**
 *
 * @author papar
 */
@Embeddable
@Check(name = "POSITIVE_REPS", constraints = "MINREPS > 0 AND MAXREPS > 0")
@Check(name = "VALID_REPS", constraints = "MINREPS <= MAXREPS")
public class RepRange {
    
    @Column(name = "MINREPS")
    private int minReps;
    
    @Column(name = "MAXREPS")
    private int maxReps;

    public RepRange() {}    

    public RepRange(int minReps, int maxReps) {
        this.minReps = minReps;
        this.maxReps = maxReps;
    }

    public int getMinReps() {
        return minReps;
    }

    public int getMaxReps() {
        return maxReps;
    }
    
}
