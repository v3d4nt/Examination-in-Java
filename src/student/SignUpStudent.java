package student;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;

public class SignUpStudent extends JFrame implements ActionListener{
	
	JTextField nameArea, emailArea, mobileArea, otherText;
	JPasswordField passwordArea;
	JComboBox qualification, passingYear;
	JLabel nameLabel, emailLabel, mobileLabel, otherLabel, passwordlabel, qualificationLabel, passingYearLabel;
	JButton signUpButton;
	
	public void showUI() {
		
		String qualifications[] = {"DIPLOMA", "B.Tech", "BCA", "MCA", "OTHERS"};
		String yearOfPassing[] = {"2018","2019","2020"};
		super.setTitle("Sign-Up");
		Font font = new Font("SansSerif", Font.ROMAN_BASELINE, 15);
		super.setResizable(false);
		super.setBounds(400, 20, 465, 480);
		
		nameArea = new JTextField();
		nameArea.setBounds(200, 30, 220, 25);
		nameArea.setFont(font);
		super.add(nameArea);
		
		emailArea = new JTextField();
		emailArea.setBounds(200, 80, 220, 25);
		emailArea.setFont(font);
		super.add(emailArea);
		
		passwordArea = new JPasswordField();
		passwordArea.setBounds(200, 130, 220, 25);
		passwordArea.setFont(font);
		super.add(passwordArea);
		
		mobileArea = new JTextField();
		mobileArea.setBounds(200, 180, 220, 25);
		mobileArea.setFont(font);
		super.add(mobileArea);
		
		qualification = new JComboBox(qualifications);
		qualification.setBounds(200, 230, 220, 25);
		qualification.setFont(font);
		super.add(qualification);
		
		otherText = new JTextField();
		otherText.setBounds(200, 280, 220, 25);
		otherText.setFont(font);
		super.add(otherText);
		
		passingYear = new JComboBox(yearOfPassing);
		passingYear.setBounds(200, 330, 220, 25);
		passingYear.setFont(font);
		super.add(passingYear);
		
		nameLabel = new JLabel("NAME *");
		nameLabel.setBounds(70, 30, 220, 25);
		nameLabel.setFont(font);
		super.add(nameLabel);
		
		emailLabel = new JLabel("EMAIL *");
		emailLabel.setBounds(70, 80, 220, 25);
		emailLabel.setFont(font);
		super.add(emailLabel);
		
		passwordlabel = new JLabel("PASSWORD *");
		passwordlabel.setBounds(70, 130, 220, 25);
		passwordlabel.setFont(font);
		super.add(passwordlabel);
		
		mobileLabel = new JLabel("MOBILE *");
		mobileLabel.setBounds(70, 180, 220, 25);
		mobileLabel.setFont(font);
		super.add(mobileLabel);
		
		qualificationLabel = new JLabel("QUALIFICATION *");
		qualificationLabel.setBounds(70, 230, 220, 25);
		qualificationLabel.setFont(font);
		super.add(qualificationLabel);
		
		otherLabel = new JLabel("OTHER");
		otherLabel.setBounds(70, 280, 220, 25);
		otherLabel.setFont(font);
		super.add(otherLabel);
		
		passingYearLabel = new JLabel("PASSING YEAR *");
		passingYearLabel.setBounds(70, 330, 220, 25);
		passingYearLabel.setFont(font);
		super.add(passingYearLabel);
		
		signUpButton = new JButton("SIGN-UP");
		signUpButton.setBounds(125,385, 220, 35);
		signUpButton.addActionListener(this);
		super.add(signUpButton);
		
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(3);
	}
	
	public static void main(String[] args) {
		
		SignUpStudent sUpStudent = new SignUpStudent();
		sUpStudent.showUI();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(String.valueOf(qualification.getSelectedItem()).equals("OTHERS"))
			otherText.setEditable(true);
		
		if(e.getSource() == signUpButton) {
			
			try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student","root","vm8206902");
					Statement sm = connection.createStatement();
					if(nameArea.getText().isEmpty()||emailArea.getText().isEmpty()||mobileArea.getText().isEmpty()||
							passwordArea.getText().isEmpty())
						JOptionPane.showMessageDialog(this, "Fields marked with * can't be empty");
					else {
							String query = "insert into studentinfo values ('"+nameArea.getText()+"','"+emailArea.getText()
							+"','"+passwordArea.getText()+"','"+mobileArea.getText()+"','"+String.valueOf(qualification.getSelectedItem())+
							"','"+otherText.getText()+"','"+String.valueOf(passingYear.getSelectedItem())+"')";
							int i = sm.executeUpdate(query);
							if(i==1)
							JOptionPane.showMessageDialog(this, "Signing Up Successfull...!\nRedirecting you to the Login Page");
							super.dispose();
							StudentLogin login = new StudentLogin();
							login.showUI();
					}
			}catch (Exception e1) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Error while Signing Up");

				e1.printStackTrace();
			}
			
			
			
		}
		
	}

}
