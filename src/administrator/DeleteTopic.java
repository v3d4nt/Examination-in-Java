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

public class DeleteTopic extends JFrame implements ActionListener{
	
	JComboBox topicList;
	JLabel topicLabel;
	JButton deleteTopic;
	ArrayList listTopics;
	
	public void showUI() {
		
		super.setTitle("Delete a Topic");
		super.setBounds(100, 20, 300, 200);
		super.setResizable(false);
		Font font = new Font("SansSerif", Font.ROMAN_BASELINE, 17);
		topicList = new JComboBox();
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
		
		String[] array = new String[listTopics.size()];
		for(int i = 0; i < array.length; i++)
			array[i] = (String) listTopics.get(i);
		topicList = new JComboBox<>(array);
		topicList.setBounds(120, 35, 150, 25);
		topicList.setFont(font);
		super.add(topicList);
		
		topicLabel = new JLabel("Select Topic");
		topicLabel.setBounds(15, 35, 120, 25);
		topicLabel.setFont(font);
		super.add(topicLabel);
		
		deleteTopic = new JButton("DELETE TOPIC");
		deleteTopic.setBounds(120, 90, 120, 30);
		deleteTopic.addActionListener(this);
		super.add(deleteTopic);
		
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(3);
	}

	public static void main(String[] args) {
		
		DeleteTopic dt = new DeleteTopic();
		dt.showUI();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == deleteTopic) {
			
			try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pejs",
																		"root", "vm8206902");
					Statement statement2 = connection.createStatement();
					
					int i = statement2.executeUpdate("drop table " + String.valueOf(topicList.getSelectedItem()));
					
						JOptionPane.showMessageDialog(this, "Topic has been deleted Sucessfully...!");
					AdminGateWay aGateWay = new AdminGateWay();
					aGateWay.showUI();
						
				
			
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
			JOptionPane.showMessageDialog(this, "This topic can't be deleted right now");
		}
			
		}
	}
}
