/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simpletrainingapp;

import com.mycompany.simpletrainingapp.entities.Routine;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author papar
 */
public class RoutineButton extends JButton{
    
    private Routine routine;
    
    public RoutineButton(Routine routine){
        this.routine = routine;
        this.setBackground(new java.awt.Color(240, 240, 240));
        this.setFont(new java.awt.Font("SansSerif", 0, 24));
        this.setForeground(new java.awt.Color(0, 204, 255));
        this.setText(routine.getName());
        this.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 255), 2, true));
        this.setFocusable(false);
        this.addActionListener((e) -> {
            var frame = (JFrame) SwingUtilities.getRoot(this);
            var contentPane = frame.getContentPane();
            contentPane.add(new RoutinePanel(routine));
            var cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.next(contentPane);
        });
    }
    
}
