package administrator;

import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;


public class AddTopic extends JFrame implements ActionListener {
	
	JTextField topicText;
	JLabel topicLabel;
	JButton addTopic;
	
	
	public void showUI() {
		
		Font font = new Font("SansSerif", Font.ROMAN_BASELINE, 15);

		super.setBounds(400, 20, 400, 200);
		super.setTitle("Add a new Topic");
		
		topicText = new JTextField();
		topicText.setBounds(150, 30, 200, 30);
		topicText.setFont(font);
		super.add(topicText);
		
		topicLabel = new JLabel("TOPIC");
		topicLabel.setBounds(50, 30, 100, 30);
		topicLabel.setFont(font);
		super.add(topicLabel);
		
		addTopic = new JButton("ADD");
		addTopic.setBounds(200, 90, 100, 30);
		super.add(addTopic);
		
		addTopic.addActionListener(this);
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(3);
		
		
	}
	
	public static void main(String[] args) {
		
		AddTopic topic = new AddTopic();
		topic.showUI();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		

		if(e.getSource() == addTopic) {
			
			try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pejs",
																		"root", "vm8206902");
					Statement statement = connection.createStatement();
					
					statement.executeUpdate("create table if not exists "+String.valueOf(topicText.getText())
							+ " (question varchar(2000), ans1 varchar(2000), ans2 varchar(2000),"
							+ " ans3 varchar (1000), ans4 varchar(1000), correct_ans varchar(1000))");
					
					JOptionPane.showMessageDialog(this, "Topic added successfully...!\nRedirecting"
							+ " you to the Admin Gateway");
					super.dispose();
					AdminGateWay gateWay = new AdminGateWay();
					gateWay.showUI();
					
					
				
			} catch (Exception e2) {

				e2.printStackTrace();
				JOptionPane.showMessageDialog(this, "Cant create this Topic...!");
				super.dispose();
				AdminGateWay gateWay = new AdminGateWay();
				gateWay.showUI();	
			
			}
			
		}
		
	}

}
