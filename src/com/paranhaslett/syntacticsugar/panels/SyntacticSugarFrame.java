package com.paranhaslett.syntacticsugar.panels;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import java.awt.CardLayout;

public class SyntacticSugarFrame extends JFrame {

  private static final long serialVersionUID = 8714190777793151752L;

  public SyntacticSugarFrame() {
    setBounds(100, 100, 478, 351);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    MenuPanel.setFrame(this);
    getContentPane().setLayout(new CardLayout(0, 0));
    new MenuPanel("StartMenu.txt");
  }

  public void update(String title, MenuPanel menuPanel) {
    setTitle(title);
    getContentPane().removeAll();
    getContentPane().add(menuPanel, BorderLayout.NORTH);
    //revalidate();
    setVisible(true);
  }

}
