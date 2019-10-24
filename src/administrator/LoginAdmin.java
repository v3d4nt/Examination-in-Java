package administrator;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginAdmin extends JFrame implements ActionListener{
	
	JPasswordField secretNumberField;
	JButton resendSecretButton, loginButton;
	String secretNoVerify, secretNumber;
	JLabel secretNumberLabel;

	public void showUI() {
		
		SendSecretNumber login = new SendSecretNumber();
		secretNumber = login.sendMail();
		super.setTitle("Administrator Log-In");
		super.setBounds(400, 50, 500, 250);
		super.setResizable(false);
		
		Font font = new Font("SansSerif", Font.ROMAN_BASELINE, 17);
		
		secretNumberField = new JPasswordField();
		secretNumberField.setBounds(200, 50, 250, 35);
		super.add(secretNumberField);
		
		secretNumberLabel = new JLabel("Enter Secret No ");
		secretNumberLabel.setBounds(70, 50, 250, 35);
		secretNumberLabel.setFont(font);
		super.add(secretNumberLabel);
		
		loginButton = new JButton("Log-In");
		loginButton.setBounds(360, 120, 100, 35);
		super.add(loginButton);
		
		resendSecretButton = new JButton("Resend Secret No");
		resendSecretButton.setBounds(180, 120, 150, 35);
		super.add(resendSecretButton);
		
		loginButton.addActionListener(this);
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		
		LoginAdmin loginAdmin = new LoginAdmin();
		loginAdmin.showUI();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == loginButton) {
			
			
			if(secretNumber.equals(secretNumberField.getText().toString())){
				
				AdminGateWay gateWay = new AdminGateWay();
				gateWay.showUI();
				
			}
			else
				JOptionPane.showMessageDialog(this, "Error\nThe secret number is Incorrect");
			
		}
		
	}
	
}
