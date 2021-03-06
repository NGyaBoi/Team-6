package MeterDash;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import MeterDash.DisplayGUI.ButtonListener;

public class DisplayGUI extends JFrame
{
	//declares category labels
	JLabel lblFirstName, lblLastName, lblNation, lblLaneNumber,
	lblReactionTime, lblFinishTime, lblRanking, lblVoid, lblSpacing;
	
	//declares displayed information
	JLabel displayFirstName, displayLastName, displayNation,
	displayLaneNumber, displayReactionTime, displayFinishTime, displayRanking;
	
	String strSpacingTest = "      ";
	
	//formats height and width of displayGUI
	private static final int frame_HEIGHT = 350;
	private static final int frame_WIDTH = 300;
	
	boolean pointer = false;
	
	public DisplayGUI(String FirstName, String LastName, String Nation, int LaneNumber, double ReactionTime, double FinishingTime, int Ranking)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Display");
		setSize(frame_HEIGHT, frame_WIDTH);
		
		//constructs labels
		lblFirstName = new JLabel("  First Name:");	
		lblLastName = new JLabel("  Last Name:");
		lblNation = new JLabel("  Nation:");
		lblLaneNumber = new JLabel("  Lane Number:");
		lblReactionTime = new JLabel("  Reaction Time:");
		lblFinishTime = new JLabel("  Finishing Time:");
		lblRanking = new JLabel("  Ranking:");
		lblVoid = new JLabel("");
		lblSpacing = new JLabel("");
		
		//constructs displayed information
		this.displayFirstName = new JLabel(FirstName + strSpacingTest);	
		this.displayLastName = new JLabel(LastName + strSpacingTest);
		this.displayNation = new JLabel(Nation + strSpacingTest);
		this.displayLaneNumber = new JLabel(Integer.toString(LaneNumber) + strSpacingTest);
		this.displayReactionTime = new JLabel(Double.toString(ReactionTime) + " seconds" + strSpacingTest);
		this.displayFinishTime = new JLabel(Double.toString(FinishingTime) + " seconds" + strSpacingTest);
		this.displayRanking = new JLabel(Integer.toString(Ranking) + strSpacingTest);
		
		//sets panel layout
		JPanel ComboPanel = new JPanel();
		ComboPanel.setLayout(new GridLayout(8,1));;
		JPanel DisplayPanel = new JPanel();
		DisplayPanel.setLayout(new GridLayout(8,1));;
		
		//border layout
		add(DisplayPanel, BorderLayout.EAST);
		add(ComboPanel, BorderLayout.WEST);
		
		/* displays combo and display panels
		 * by which checkboxes have been selected
		 */
		if(GUi.FirstName.isSelected()==true) {
			ComboPanel.add(lblFirstName);
			DisplayPanel.add(displayFirstName); }
		else {
			ComboPanel.add(lblVoid);
			DisplayPanel.add(lblVoid); }
		
		if(GUi.LastName.isSelected()==true) {
			ComboPanel.add(lblLastName);
			DisplayPanel.add(displayLastName); }
		else {
			ComboPanel.add(lblVoid);
			DisplayPanel.add(lblVoid); }
		
		if(GUi.Nation.isSelected()==true) {
			ComboPanel.add(lblNation);
			DisplayPanel.add(displayNation); }
		else {
			ComboPanel.add(lblVoid);
			DisplayPanel.add(lblVoid); }
		
		if(GUi.LaneNumber.isSelected()==true) {
			ComboPanel.add(lblLaneNumber);
			DisplayPanel.add(displayLaneNumber); }
		else {
			ComboPanel.add(lblVoid);
			DisplayPanel.add(lblVoid); }
		
		if(GUi.ReactionTime.isSelected()==true) {
			ComboPanel.add(lblReactionTime);
			DisplayPanel.add(displayReactionTime); }
		else {
			ComboPanel.add(lblVoid);
			DisplayPanel.add(lblVoid); }
		
		if(GUi.FinishTime.isSelected()==true) {
			ComboPanel.add(lblFinishTime);
			DisplayPanel.add(displayFinishTime); }
		else {
			ComboPanel.add(lblVoid);
			DisplayPanel.add(lblVoid); }
		
		if(GUi.Ranking.isSelected()==true) {
			ComboPanel.add(lblRanking);
			DisplayPanel.add(displayRanking); }
		else {
			ComboPanel.add(lblVoid);
			DisplayPanel.add(lblVoid);}
				
			ComboPanel.add(lblSpacing);
			DisplayPanel.add(lblVoid);
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,3));
		JButton exit = new JButton("Exit");
		buttonPanel.add(exit);
		add(buttonPanel, BorderLayout.SOUTH);
		
		//button listener
		do 
		{
			ButtonListener listener = new ButtonListener();
			exit.addActionListener(listener);
			//VaA.addActionListener(listener);
		} while(pointer);
	}
	
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
			{
				switch(e.getActionCommand())
				{
					case "Clear":
						break;
					case "View Another Athlete":
						dispose();
						break;
					case "Exit":
						dispose();
						break;
				}
			}
	}
}
