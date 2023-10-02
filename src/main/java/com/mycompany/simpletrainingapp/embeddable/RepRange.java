/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp.embeddable;

import jakarta.persistence.Embeddable;
import org.hibernate.annotations.Check;

/**
 *
 * @author papar
 */
@Embeddable
@Check(name = "positiveReps", constraints = "minReps > 0 AND maxReps> 0")
@Check(name = "validReps", constraints = "minReps <= maxReps")
public class RepRange {
    
    private int minReps;
    
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
