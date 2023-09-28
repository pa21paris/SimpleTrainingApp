/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @Column(unique = true)
    private String name;
    private String instructions;
    private String videoLink;
    private Muscle targetMuscle;
    private final Set<Exercise> variations = new HashSet<>();
    private final Set<Muscle> synergistMuscles = new HashSet<>();

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
        
}
