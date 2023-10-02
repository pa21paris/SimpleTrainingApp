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
import java.util.Set;

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
    private final Set<Muscle> synergistMuscles = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "ExercisesVariations")
    private final Set<Exercise> variations = new HashSet<>();
    @OneToMany(mappedBy = "id.exercise")
    private final Set<RoutineExercise> routines = new HashSet<>();

    public Exercise() {}    

    public Exercise(String name, String instructions, String videoLink, Muscle targetMuscle) {
        this.name = name;
        this.instructions = instructions;
        this.videoLink = videoLink;
        this.targetMuscle = targetMuscle;
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
        return this.variations.add(variation);
    }
    
    public boolean removeVariation(Exercise variation) {
        return this.variations.remove(variation);
    }

    public Muscle getTargetMuscle() {
        return targetMuscle;
    }

    public void setTargetMuscle(Muscle targetMuscle) {
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
    
    public Set<RoutineExercise> getRoutines() {
        return Set.copyOf(routines);
    }

    public boolean addRoutine(RoutineExercise routine) {
        return this.routines.add(routine);
    }
    
    public boolean removeRoutine(RoutineExercise routine) {
        return this.routines.remove(routine);
    }
        
}
