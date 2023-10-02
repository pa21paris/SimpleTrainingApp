/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp.entities;

import com.mycompany.simpletrainingapp.embeddable.RepRange;
import com.mycompany.simpletrainingapp.embeddable.RoutineExerciseId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
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
    @OneToMany(mappedBy = "id.routineExercise")
    private final Set<SetRecord> sets = new HashSet<>();

    public RoutineExercise() {}

    public RoutineExercise(
            RoutineExerciseId id, RepRange expectedRepRange, int expectedWeight, int expectedSets
    ) {
        this.id = id;
        this.expectedRepRange = expectedRepRange;
        this.expectedWeight = expectedWeight;
        this.expectedSets = expectedSets;
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

    public int getExpectedSets() {
        return expectedSets;
    }

    public void setExpectedSets(int expectedSets) {
        this.expectedSets = expectedSets;
    }
    
    public Set<SetRecord> getSets() {
        return Set.copyOf(sets);
    }
    
    public boolean addSet(SetRecord set){
        return this.sets.add(set);
    }
    
    public boolean removeSet(SetRecord set){
        return this.sets.remove(set);
    }

}
