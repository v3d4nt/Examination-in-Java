package student;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StudentGateWay extends JFrame implements ActionListener{
	
	JButton signUpButton, loginButton, giveExamButton, feedbackButton, jobSeekButton, resultButton;
	
	public void showUI() {
		
		super.setResizable(false);
		super.setBounds(300, 20, 350, 300);
		super.setTitle("Student-Gateway");
		super.getContentPane().setBackground(Color.decode("#03F"));
		
		signUpButton = new JButton("SIGN-UP");
		signUpButton.setBounds(50, 50, 250, 60);
		signUpButton.addActionListener(this);
		super.add(signUpButton);
		
		loginButton = new JButton("LOGIN");
		loginButton.setBounds(50, 165, 250, 60);
		loginButton.addActionListener(this);
		super.add(loginButton);
		
		
		
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(3);
	}
	
	public static void main(String[] args) {
		
		StudentGateWay gateWay = new StudentGateWay();
		gateWay.showUI();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == loginButton) {
			super.dispose();
			StudentLogin sl = new StudentLogin();
			sl.showUI();
			
			
		}
		
	}

}
