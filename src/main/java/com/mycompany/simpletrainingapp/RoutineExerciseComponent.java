/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.simpletrainingapp;

import com.mycompany.simpletrainingapp.entities.Exercise;
import com.mycompany.simpletrainingapp.entities.RoutineExercise;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author papar
 */
public class RoutineExerciseComponent extends javax.swing.JPanel {
    
    private RoutineExercise routineExercise;

    /**
     * Creates new form ExerciseComponent
     * @param routineExercise
     */
    public RoutineExerciseComponent(RoutineExercise routineExercise) {
        this.routineExercise = routineExercise;
        initComponents();
        Exercise exercise = routineExercise.getExercise();
        exerciseNameLabel.setText(exercise.getName());
        muscleGroupLabel.setText(exercise.getTargetMuscle().getMuscleGroup().getName());
        repRangeLabel.setText(routineExercise.getExpectedRepRange().toString());
        setQuantityLabel.setText(String.valueOf(routineExercise.getExpectedSets()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exerciseNameLabel = new javax.swing.JLabel();
        addSetButton = new javax.swing.JButton();
        muscleGroupLabel = new javax.swing.JLabel();
        showDetailsButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        repRangeLabel = new javax.swing.JLabel();
        setQuantityLabel = new javax.swing.JLabel();
        editButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(240, 240, 240));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 255)));

        exerciseNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        exerciseNameLabel.setForeground(new java.awt.Color(0, 204, 255));
        exerciseNameLabel.setText("Exercise Name");

        addSetButton.setBackground(new java.awt.Color(45, 45, 255));
        addSetButton.setForeground(new java.awt.Color(232, 232, 232));
        addSetButton.setText("Add set");
        addSetButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        addSetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSetButtonActionPerformed(evt);
            }
        });

        muscleGroupLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        muscleGroupLabel.setForeground(new java.awt.Color(0, 204, 255));
        muscleGroupLabel.setText("Muscle group");

        showDetailsButton1.setBackground(new java.awt.Color(204, 204, 204));
        showDetailsButton1.setForeground(new java.awt.Color(0, 137, 173));
        showDetailsButton1.setText("Show exercise details");
        showDetailsButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        showDetailsButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showDetailsButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 255));
        jLabel1.setText("Rep range");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 255));
        jLabel3.setText("Number of sets");

        repRangeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        repRangeLabel.setForeground(new java.awt.Color(0, 204, 255));
        repRangeLabel.setText("repRangeValue");

        setQuantityLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        setQuantityLabel.setForeground(new java.awt.Color(0, 204, 255));
        setQuantityLabel.setText("setsValue");

        editButton.setBackground(new java.awt.Color(204, 204, 204));
        editButton.setForeground(new java.awt.Color(0, 137, 173));
        editButton.setText("Edit");
        editButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exerciseNameLabel)
                    .addComponent(muscleGroupLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(repRangeLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(setQuantityLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addSetButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showDetailsButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(editButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(muscleGroupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(repRangeLabel))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(setQuantityLabel))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addSetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exerciseNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(showDetailsButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addSetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSetButtonActionPerformed
        var rootFrame = (JFrame)SwingUtilities.getRoot(this);
        var addSet = new AddSetWindow(routineExercise.getExercise(), rootFrame);
        addSet.setVisible(true);
        addSet.setLocationRelativeTo(rootFrame);
        rootFrame.setEnabled(false);
    }//GEN-LAST:event_addSetButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editButtonActionPerformed

    private void showDetailsButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showDetailsButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showDetailsButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSetButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel exerciseNameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel muscleGroupLabel;
    private javax.swing.JLabel repRangeLabel;
    private javax.swing.JLabel setQuantityLabel;
    private javax.swing.JButton showDetailsButton1;
    // End of variables declaration//GEN-END:variables
}
