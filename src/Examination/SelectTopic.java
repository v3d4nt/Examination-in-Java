package Examination;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class SelectTopic extends JFrame implements ActionListener {
	
	 ArrayList<String> listTopics;
	 JComboBox<String> topicList;
	 JLabel nameLabel, topicLabel;
	 JButton giveExam;
     String name1, topic,email;	
	public  void showUI(String name,String email1) {
		
		try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pejs",
																	"root", "vm8206902");
				Statement statement1 = connection.createStatement();
				DatabaseMetaData md = connection.getMetaData();
				ResultSet rs = md.getTables("pejs", null, "%", null);
				listTopics = new ArrayList<>();
				while (rs.next()) {
		                listTopics.add(rs.getString(3).toUpperCase());
				
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		name1 = name;
		email = email1;
		super.setBounds(400, 50, 350, 180);
		super.setResizable(false);

		Font font = new Font("SansSerif", Font.ROMAN_BASELINE, 15);
		
		String[] array = new String[listTopics.size()];
		for(int i = 0; i < array.length; i++)
			array[i] = listTopics.get(i);
		
		nameLabel = new JLabel("***********  Welcome "
				   + ""+name+"  ***********");
		nameLabel.setBounds(20, 5, 300, 25);
		super.add(nameLabel);
		
		topicList = new JComboBox<>(array);
		topicList.setBounds(150, 50, 150, 25);
		topicList.setFont(font);
		super.add(topicList);
		
		topicLabel = new JLabel("Select Topic");
		topicLabel.setBounds(30, 50, 100, 30);
		topicLabel.setFont(font);
		super.add(topicLabel);
		
		giveExam = new JButton("PROCEED TO EXAM");
		giveExam.setBounds(150, 100, 150, 35);
		super.add(giveExam);
		giveExam.addActionListener(this);
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(3);

	}
	
	public static void main(String[] args) {
		
		SelectTopic selectTopic = new SelectTopic();
		selectTopic.showUI("Vedant","itsv3d4nt");
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e2) {
		// TODO Auto-generated method stub
		if(e2.getSource() == giveExam) {
			topic = String.valueOf(topicList.getSelectedItem());
			super.dispose();
			InstructionsBeforeExam i = new InstructionsBeforeExam();
			i.showUI(name1, topic,email);
		}
		
		
	}
}
