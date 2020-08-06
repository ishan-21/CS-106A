/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends Program implements NameSurferConstants{

/* Method: init() */
/**
 * This method has the responsibility for reading in the data base
 * and initializing the interactors at the bottom of the window.
 */ 
	public void init() {
		display = new NameSurferGraph();
		add( display );
	}
			
	public void run() {
		database = new NameSurferDataBase( NAMES_DATA_FILE );
	    add( new JLabel("Name: ") , SOUTH );
	    text = new JTextField( WORD_LIMIT );
	    text.setText( "Goliath" );
	    text.addActionListener( this );
	    graph = new JButton("GRAPH");
	    clear = new JButton("CLEAR");
	    add( text , SOUTH );
	    add( graph , SOUTH );
	    add( clear , SOUTH );
	    display.update();
	    addActionListeners();
	}

/* Method: actionPerformed(e) */
/**
 * This class is responsible for detecting when the buttons are
 * clicked, so you will have to define a method to respond to
 * button actions.
 */
	public void actionPerformed(ActionEvent e) {
		if( e.getSource() == graph || e.getSource() == text ) {
			display.addEntry( database.findEntry( text.getText()));
			display.update();
		}if( e.getSource() == clear ) {
			display.clear();
			display.update();
		}
	}
	

	
	private JTextField text;
	private JButton graph;
	private JButton clear;
	private NameSurferGraph display;
	private NameSurferDataBase database;
}
