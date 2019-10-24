package Examination;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Examination extends JFrame implements ActionListener {
	
	JTextArea quesArea;
	String getName, getTopic;
	JLabel nameLabel, aLabel, bLabel, cLabel, dLabel;
	JButton nextButton;
	JRadioButton a, b, c, d;
	int i = 0, j = 0;
	static double score = 0;
	String[] questions = new String[10];
	String[] optionA = new String[10];
	String[] optionB = new String[10];
	String[] optionC = new String[10];
	String[] optionD = new String[10];
	String[] correctOption = new String[10];
	String[] userSelected = new String[10];
	String usersEmail;
 	public void showUI(String name, String topic, String email) {
		
		usersEmail = email;
		super.setBounds(300, 20, 800, 600);
		super.setTitle("Examination");
		
		getName = name;
		getTopic = topic;
		

		try {
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pejs","root","vm8206902");
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery("select * from " + topic);
				while(rs.next()) {
					questions[i] = rs.getString("question");
					optionA[i] = rs.getString("ans1");
					optionB[i] = rs.getString("ans2");
					optionC[i] = rs.getString("ans3");
					optionD[i] = rs.getString("ans4");
					correctOption[i] = rs.getString("correct_ans");
					System.out.println(questions[i]);
					System.out.println(optionA[i]);
					System.out.println(optionB[i]);
					System.out.println(optionC[i]);
					System.out.println(optionD[i]);
					System.out.println(correctOption[i]);
					i=(i+1)%10;
						

				}
				i = 0;
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Font font = new Font("SansSerif", Font.ROMAN_BASELINE, 15);
		
		nameLabel = new JLabel("************************************ "
				+ " Welcome " + name + "  *************************************** ");
		nameLabel.setBounds(30, 10, 750, 30);
		nameLabel.setFont(font);
		super.add(nameLabel);
		
		quesArea = new JTextArea(questions[j]);
		quesArea.setFont(font);
		quesArea.setEditable(false);
		JScrollPane pane = new JScrollPane(quesArea);
		pane.setBounds(10, 70, 650, 70);
		super.add(pane);		
		
		aLabel = new JLabel(optionA[j]);
		aLabel.setBounds(40, 160, 650, 25);
		aLabel.setFont(font);
		super.add(aLabel);
		
		bLabel = new JLabel(optionB[j]);
		bLabel.setBounds(40, 205, 650, 25);
		bLabel.setFont(font);
		super.add(bLabel);
		
		cLabel = new JLabel(optionC[j]);
		cLabel.setBounds(40, 250, 650, 25);
		cLabel.setFont(font);
		super.add(cLabel);
		
		dLabel = new JLabel(optionD[j]);
		dLabel.setBounds(40, 290, 650, 25);
		dLabel.setFont(font);
		super.add(dLabel);
		
		a = new JRadioButton();
		a.setBounds(13, 162, 25, 25);
		super.add(a);
		
		b = new JRadioButton();
		b.setBounds(13, 207, 25, 25);
		super.add(b);
		
		c = new JRadioButton();
		c.setBounds(13, 252, 25, 25);
		super.add(c);
		
		d = new JRadioButton();
		d.setBounds(13, 292, 25, 25);
		super.add(d);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(a);
		bg.add(b);
		bg.add(c);
		bg.add(d);
		a.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		d.addActionListener(this);
		
		nextButton = new JButton("Next");
		nextButton.setBounds(100, 330, 70, 35);
		super.add(nextButton);
		nextButton.addActionListener(this);
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(3);
		
	}
	
	public static void main(String[] args) {
		Examination exam = new Examination();
		exam.showUI("Vedant", "c", "itsv3d4nt@gmail.com");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == nextButton) {
			
			if(a.isSelected()) {
				System.out.println("A selected");
				if(correctOption[i].equals("a")) {
					score++;
				}	
				else  
					score = score = score - 0.25;
				System.out.println("Score is " + score + " and correct option is " + correctOption[i]);
				userSelected[i] = "a";
			}
			
			else if(b.isSelected()) {
				System.out.println("B selected");
				if(correctOption[i].equals("b")) {
					score++;
				}
				else  
					score = score = score - 0.25;
				System.out.println("Score is " + score + " and correct option is " + correctOption[i]);
				userSelected[i] = "b";
			}
			
			else if(c.isSelected()) {
				System.out.println("C selected");
				if(correctOption[i].equals("c")) {
					score++;
				}
				else  
					score = score = score - 0.25;
				System.out.println("Score is " + score + " and correct option is " + correctOption[i]);
				userSelected[i] = "c";
			}
			
			else if(d.isSelected()) {
				System.out.println("D selected");
				if(correctOption[i].equals("d")) {
					score++;
					
				}
				else  
					score = score = score - 0.25;
				System.out.println("Score is " + score + " and correct option is " + correctOption[i]);
				userSelected[i] = "d";
			}
			
			i=(i+1)%10;
			j=(j+1)%10;
			if(!(i==0)) {
				quesArea.setText(questions[i]);
				aLabel.setText(optionA[i]);
				bLabel.setText(optionB[i]);
				cLabel.setText(optionC[i]);
				dLabel.setText(optionD[i]);
			}
			else {
				int a = JOptionPane.showConfirmDialog(this, "You scored "+ score + "\nPress Yes to email your result.\nPress no"
						+ " to continue to result window.");
				if(a == JOptionPane.YES_OPTION) {
					SendResult se = new SendResult();
					try {
						se.sendResult(userSelected, correctOption, score, usersEmail);
						JOptionPane.showMessageDialog(this, "Result has been sent successsfully...!");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				ExamResult er = new ExamResult();
				er.showUI(userSelected, correctOption, score);
			}
			
		}
		
	}
	
}
