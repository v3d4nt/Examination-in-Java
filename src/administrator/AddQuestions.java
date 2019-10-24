package administrator;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;

public class AddQuestions extends JFrame implements ActionListener {
	
	JComboBox<String> topicList;
	JLabel topicLabel,quesLabel, ans1Label, ans2Label, ans3Label, ans4Label, correctLabel;
	JTextArea quesArea, ans1Area, ans2Area, ans3Area, ans4Area, correctArea;
	JButton addQuestion;
	ArrayList<String> listTopics;
	
	
	public  void showUI() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pejs",
																"root", "vm8206902");
			Statement statement1 = connection.createStatement();
			DatabaseMetaData md = connection.getMetaData();
			ResultSet rs = md.getTables("pejs", null, "%", null);
			listTopics = new ArrayList<>();
			while (rs.next()) {
					System.out.println(rs.getString(3));
	                listTopics.add(rs.getString(3).toUpperCase());
			
			}
			} catch (Exception e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}
		
		super.setBounds(400, 50, 500, 650);
		super.setResizable(false);

		Font font = new Font("SansSerif", Font.ROMAN_BASELINE, 15);
		
		String[] array = new String[listTopics.size()];
		for(int i = 0; i < array.length; i++)
			array[i] = listTopics.get(i);
		topicList = new JComboBox<>(array);
		topicList.setBounds(180, 25, 250, 25);
		topicList.setFont(font);
		super.add(topicList);
		
		topicLabel = new JLabel("Topic");
		topicLabel.setBounds(100, 15, 100, 50);
		topicLabel.setFont(font);
		super.add(topicLabel);

		quesArea = new JTextArea();
		JScrollPane pane1 = new JScrollPane(quesArea);
		pane1.setBounds(180, 80, 250, 50);
		super.add(pane1);
		quesLabel = new JLabel("Question");
		quesLabel.setBounds(90, 65, 100, 50);
		quesLabel.setFont(font);
		super.add(quesLabel);
		
		ans1Area = new JTextArea();
		JScrollPane pane2 = new JScrollPane(ans1Area);
		pane2.setBounds(180, 160, 250, 50);
		super.add(pane2);
		ans1Label = new JLabel("Option A");
		ans1Label.setBounds(90, 145, 100, 50);
		ans1Label.setFont(font);
		super.add(ans1Label);
		
		ans2Area = new JTextArea();
		JScrollPane pane3 = new JScrollPane(ans2Area);
		pane3.setBounds(180, 240, 250, 50);
		super.add(pane3);
		ans2Label = new JLabel("Option B");
		ans2Label.setBounds(90, 225, 100, 50);
		ans2Label.setFont(font);
		super.add(ans2Label);
		
		ans3Area = new JTextArea();
		JScrollPane pane4 = new JScrollPane(ans3Area);
		pane4.setBounds(180, 320, 250, 50);
		super.add(pane4);
		ans3Label = new JLabel("Option C");
		ans3Label.setBounds(90, 305, 100, 50);
		ans3Label.setFont(font);
		super.add(ans3Label);
		
		ans4Area = new JTextArea();
		JScrollPane pane5 = new JScrollPane(ans4Area);
		pane5.setBounds(180, 400, 250, 50);
		super.add(pane5);
		ans4Label = new JLabel("Option D");
		ans4Label.setBounds(90, 385, 100, 50);
		ans4Label.setFont(font);
		super.add(ans4Label);
		
		correctArea = new JTextArea();
		JScrollPane pane6 = new JScrollPane(correctArea);
		pane6.setBounds(180, 480, 250, 50);
		super.add(pane6);
		correctLabel = new JLabel("Correct");
		correctLabel.setBounds(90, 465, 100, 50);
		correctLabel.setFont(font);
		super.add(correctLabel);
		
		addQuestion = new JButton("ADD QUESTION");
		addQuestion.setBounds(180, 570, 250, 30);
		super.add(addQuestion);
		
		addQuestion.addActionListener(this);
		
		
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(3);
		
	
		
	}
	public static void main(String[] args) {
		
		AddQuestions questions = new AddQuestions();
		questions.showUI();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == addQuestion) {
			
			try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pejs",
																		"root", "vm8206902");
					Statement statement2 = connection.createStatement();
					
					int i = statement2.executeUpdate("insert into "+String.valueOf(topicList.getSelectedItem())+
							" values('"+quesArea.getText()+"','"+ans1Area.getText()+"'"
									+ ",'"+ans2Area.getText()+"','"+ans3Area.getText()+"'"
											+ ",'"+ans4Area.getText()+"','"+correctArea.getText()+"')");
					if(i==1) {
						JOptionPane.showMessageDialog(this, "Your question has been added successfully");
					}
					else 
						JOptionPane.showMessageDialog(this, "Question can't be added right now");
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
		}
		
	}

}
