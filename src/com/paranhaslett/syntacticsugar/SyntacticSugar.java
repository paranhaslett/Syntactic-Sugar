package com.paranhaslett.syntacticsugar;

import java.awt.EventQueue;

import com.paranhaslett.syntacticsugar.panels.SyntacticSugarFrame;


public class SyntacticSugar {
  

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				  SyntacticSugarFrame ssf = new SyntacticSugarFrame();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
