
import java.awt.event.*;

import javax.swing.*;

import administrator.LoginAdmin;
import student.StudentGateWay;
public class MainPage extends JFrame implements ActionListener{
	
	JButton adminButton, studentButton, companyButton;
	
	
	public void showUI() {
		
		super.setTitle("Performance Evaluation & Job Seeking");
		
		super.setBounds(100, 20, 400, 400);
		super.setResizable(false);
		
		adminButton = new JButton("Administrator");
		adminButton.setBounds(120, 50, 150, 50);
		adminButton.addActionListener(this);
		super.add(adminButton);
		
		studentButton = new JButton("Student");
		studentButton.setBounds(120, 150, 150, 50);
		studentButton.addActionListener(this);
		super.add(studentButton);
		
		companyButton = new JButton("Company");
		companyButton.setBounds(120, 250, 150, 50);
		companyButton.addActionListener(this);
		
		super.add(companyButton);
		
		
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public static void main(String[] args) {
		
		MainPage page = new MainPage();
		page.showUI();
		
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() == adminButton) {
			
			LoginAdmin loginAdmin = new LoginAdmin();
			loginAdmin.showUI();
			
		}
		
		else if(event.getSource() == studentButton) {
			
			StudentGateWay sg = new StudentGateWay();
			sg.showUI();
			
		}
		
		else if(event.getSource() == companyButton) {
			
			
			
		}
		
	}

}
