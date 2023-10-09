/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author papar
 */
@Entity
public class Exercise {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, length = 60)
    private String name;
    private String instructions;
    private String videoLink;
    @ManyToOne(fetch = FetchType.LAZY)
    private Muscle targetMuscle;
    @ManyToMany
    @JoinTable(name = "SynergistMuscleExercise")
    private final Set<Muscle> synergistMuscles = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "ExercisesVariations")
    private final Set<Exercise> variations = new HashSet<>();
    @OneToMany(mappedBy = "id.exercise")
    private final Set<RoutineExercise> routines = new HashSet<>();
    @OneToMany(mappedBy = "id.exercise")
    private final Set<SetRecord> setHistory = new HashSet<>();

    Exercise() {}    

    public Exercise(String name, String instructions, String videoLink) {
        this.name = name;
        this.instructions = instructions;
        this.videoLink = videoLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public Set<Exercise> getVariations() {
        return Set.copyOf(variations);
    }

    public boolean addVariation(Exercise variation) {
        if(!this.variations.add(variation)) return false;
        variation.addVariation(this);
        return true;
    }
    
    public boolean removeVariation(Exercise variation) {
        if(!this.variations.remove(variation)) return false;
        variation.removeVariation(this);
        return true;
    }

    public Muscle getTargetMuscle() {
        return targetMuscle;
    }

    void setTargetMuscle(Muscle targetMuscle) {
        this.targetMuscle = targetMuscle;
    }

    public Set<Muscle> getSynergistMuscles() {
        return Set.copyOf(synergistMuscles);
    }

    public boolean addSynergistMuscle(Muscle synergistMuscle) {
        return this.synergistMuscles.add(synergistMuscle);
    }
    
    public boolean removeSynergistMuscle(Muscle synergistMuscle) {
        return this.synergistMuscles.remove(synergistMuscle);
    }
    
    public Set<Routine> getRoutines() {
        return this.routines
                .stream()
                .map(routineExercise -> routineExercise.getRoutine())
                .collect(Collectors.toSet());
    }

    boolean addRoutine(RoutineExercise routine) {
        return this.routines.add(routine);
    }
    
    boolean removeRoutine(RoutineExercise routine) {
        return this.routines.remove(routine);
    }
    
    public Set<SetRecord> getSets() {
        return Set.copyOf(setHistory);
    }

    public boolean addSet(SetRecord set) {
        return this.setHistory.add(set);
    }
    
    public boolean removeSet(SetRecord set) {
        return this.setHistory.remove(set);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.name);
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
        final Exercise other = (Exercise) obj;
        return Objects.equals(this.name, other.name);
    }
    
    
        
}
