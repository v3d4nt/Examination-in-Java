package student;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

import com.sun.org.apache.bcel.internal.generic.Select;
import com.sun.org.apache.xml.internal.serializer.ElemDesc;

import Examination.Examination;
import Examination.SelectTopic;

public class StudentLogin extends JFrame implements ActionListener{
	
	JPasswordField passwordField = new JPasswordField();
	JLabel emailMobileLabel, passwordLabel;
	JTextField emailMobileField;
	JButton loginButton, recoverPasswordButton;
	String name,email;
	public void showUI() {
		
		super.setTitle("Student-Login");
		super.setBounds(400, 30, 400, 250);
		Font font = new Font("SansSerif", Font.ROMAN_BASELINE, 16);
		super.setResizable(false);
		
		emailMobileField = new JTextField();
		emailMobileField.setBounds(170, 30, 200, 25);
		emailMobileField.setFont(font);
		super.add(emailMobileField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(170, 80, 200, 25);
		super.add(passwordField);
		
		emailMobileLabel = new JLabel("Email / Mobile");
		emailMobileLabel.setBounds(50, 30, 200, 25);
		emailMobileLabel.setFont(font);
		super.add(emailMobileLabel); 
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(50 ,80, 200, 25);
		passwordLabel.setFont(font);
		super.add(passwordLabel);  
		
		loginButton = new JButton("LOGIN");
		loginButton.setBounds(268, 130, 100, 30);
		loginButton.addActionListener(this);
		super.add(loginButton);
		
		recoverPasswordButton = new JButton("RECOVER PASSWORD");
		recoverPasswordButton.setBounds(40, 130, 170, 30);
		recoverPasswordButton.addActionListener(this);
		super.add(recoverPasswordButton);
		
		
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(3);
		
	}
	
	
	public static void main(String[] args) {
		 
		StudentLogin login = new StudentLogin();
		login.showUI();
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == loginButton) {
			
			
			
			try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student",
																	"root", "vm8206902");
					Statement statement1 = connection.createStatement();
					ResultSet rs = statement1.executeQuery("select * from studentinfo");
					int flag = 0;
					if(emailMobileField.getText().isEmpty())
						JOptionPane.showMessageDialog(this, "Email/Mobile or Password can't be empty!");
					else {
						
						while(rs.next()) {
							System.out.println(emailMobileField.getText()+" "+String.valueOf(passwordField.getPassword()));
							System.out.println(rs.getString("name")+rs.getString("email")+rs.getString("password")+rs.getString("mobile"));
							if(emailMobileField.getText().equals(rs.getString("email")) && String.valueOf(passwordField.getPassword()).equals(rs.getString("password"))) {
								flag = 1;
								System.out.println("Email&Pass Found");
								name = rs.getString("name");
								email = rs.getString("email");
								System.out.println(name);
							}
							else if(emailMobileField.getText().equals(rs.getString("mobile")) && String.valueOf(passwordField.getPassword()).equals(rs.getString("password"))) {
								flag = 1;
								System.out.println("No.&Pass Found");
								name = rs.getString("name");
								email = rs.getString("email");
								System.out.println(name);
							}
							else
								System.out.println("No Record's Matched");
						}
						if(flag == 1) {
							JOptionPane.showMessageDialog(this, "Login Sucessful!");
							super.dispose();
							SelectTopic selectTopic = new SelectTopic();
							selectTopic.showUI(name,email);
						}
						else 
							JOptionPane.showMessageDialog(this, "Login Failure, Please check your credentials");

						
					}
					
					
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
			
		
	}
	
	

}
