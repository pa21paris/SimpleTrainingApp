/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp.entities;

import com.mycompany.simpletrainingapp.embeddable.SetRecordId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import java.util.Objects;
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

    SetRecord() {}    

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
        final SetRecord other = (SetRecord) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
    
}
