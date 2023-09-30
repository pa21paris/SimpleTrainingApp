/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp.entities;

import com.mycompany.simpletrainingapp.embeddable.SetRecordId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import org.hibernate.annotations.Check;

/**
 *
 * @author papar
 */
@Entity
@Check(name = "validSet", constraints = "weightUsed > 0 AND repsDone > 0")
public class SetRecord {
    
    @EmbeddedId
    private SetRecordId id;
    private int weightUsed;
    private int repsDone;

    public SetRecord() {}    

    public SetRecord(SetRecordId id, int weightUsed, int repsDone) {
        this.id = id;
        this.weightUsed = weightUsed;
        this.repsDone = repsDone;
    }

    public SetRecordId getId() {
        return id;
    }

    public int getWeightUsed() {
        return weightUsed;
    }

    public int getRepsDone() {
        return repsDone;
    }
    
}
