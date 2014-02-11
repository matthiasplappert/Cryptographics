package edu.kit.iks.Cryptographics.Vigenere.Explanation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.kit.iks.Cryptographics.Vigenere.VigenereModel;
import edu.kit.iks.CryptographicsLib.CharacterFrequencyDiagramView;
import edu.kit.iks.CryptographicsLib.VisualizationView;

/*
 * This class represents the view of the first explanatation step. In this step a cipher will be given
 * to the user. He has the choice to create a histogramm and use an algorithm to get the length of 
 * the key. Then he has to extract the password. 
 */
public class SecondExplanationView extends VisualizationView{
	private static final long serialVersionUID = 6294968461280032987L;
	
	private CharacterFrequencyDiagramView vigenereHistogramm;
	private CharacterFrequencyDiagramView averageHistogramm;
	private JLabel explanation;
	private JLabel secondExplanation;
	private JLabel thirdExplanation;
	private JLabel wrong;
	private JTextField answer;
	
	public void setExplanation(String s){
		this.explanation.setText(s);
		Dimension size = this.explanation.getPreferredSize();
		this.explanation.setBounds(10, 10,
	             size.width, size.height);
		this.validate();
	}
	
	public void answerRight() {
		this.answer.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
		this.wrong.setVisible(false);
	}
	
	public void answerFalse() {
		this.answer.setBorder(BorderFactory.createLineBorder(Color.red, 5));
		this.wrong.setVisible(true);
		this.answer.setText("");
	}
	
	public String getAnswer() {
		return this.answer.getText();
	}
	public void visibleFirstState(boolean b) {
		this.vigenereHistogramm.setVisible(b);
		this.secondExplanation.setVisible(b);
		this.averageHistogramm.setVisible(b);
		this.thirdExplanation.setVisible(b);
		this.answer.setVisible(b);
	}
	
	public SecondExplanationView() {
		this.setLayout(null);
		this.add(new JLabel("VIGENERE EXPLANATATION"));
		this.add(this.explanation = new JLabel("<html><div width=\"1200\">Now its your turn! You have to find the second character of the key. I was kind enough to give you a diagramm of every second character encrypted with the second part of the key."
				+ "You know what to do: </div></html>"));
		this.explanation.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		
		this.add(this.secondExplanation = new JLabel("<html><div width=\"1200\">This is the average distribution of the characters in english texts:</div></html>"));
		this.secondExplanation.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		
		this.add(this.thirdExplanation = new JLabel("<html><div width=\"1200\">Look at the peaks of both histogramm and calculate the second part of the key! Your answer:</div></html>"));
		this.thirdExplanation.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		
		this.add(this.answer = new JTextField(""));
		this.answer.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		
		this.add(this.wrong = new JLabel("Wrong Answer! Try again!"));
		this.wrong.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		
		this.vigenereHistogramm = new CharacterFrequencyDiagramView(VigenereModel.getCharPositionated(1, 2, FirstExplanationView.encryptedAverageText), 600,
				100);
		this.add(this.vigenereHistogramm);
		
		this.averageHistogramm = new CharacterFrequencyDiagramView(FirstExplanationView.averageText, 600,
				100);
		this.add(this.averageHistogramm);
		
		Dimension size = this.explanation.getPreferredSize();
		this.explanation.setBounds(10, 10,
	             size.width, size.height);
		
		size = this.secondExplanation.getPreferredSize();
		this.secondExplanation.setBounds(10, 240,
	             size.width, size.height);
		
		size = this.thirdExplanation.getPreferredSize();
		this.thirdExplanation.setBounds(10, 420,
	             size.width, size.height);
		
		this.answer.setBounds(200, 460,
	             40, 40);
		this.answer.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
		
		size = this.wrong.getPreferredSize();
		this.wrong.setBounds(300, 460,
				size.width, size.height);
		this.wrong.setVisible(false);
		
		size = this.getBackButton().getPreferredSize();
		this.getBackButton().setBounds(30, 600,
	             size.width, size.height);
		
		size = this.getNextButton().getPreferredSize();
		this.getNextButton().setBounds(1100, 600,
	             size.width, size.height);
		
		this.vigenereHistogramm.setBounds(10, 140,
	             600, 100);
		this.averageHistogramm.setBounds(10, 280,
	             600, 100);
       
	}
}