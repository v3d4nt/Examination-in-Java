package Examination;

import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class InstructionsBeforeExam extends JFrame implements ActionListener {
	
	JTextArea jt;
	JButton openExamination;
	JLabel nameLabel;
	String name1, topic,email;
	public void showUI(String name, String topicSelected,String email1) {
		email = email1;
		String instruction1 = " • There are 10 questions in this examination",
		       instruction5 = " • For correctly attempted question, 1 mark will be awarded.",
			   instruction2 = " • There is a negative marking of 0.25 for every wrong answer",
			   instruction3 = " • You can't skip any queston",
			   instruction4 = " • The next question will appear only after attempting current question";
		name1 = name;  
		topic = topicSelected;
		super.setBounds(300,30, 800, 600);
		super.setTitle("Instructions");
		super.setResizable(false);
		Font font = new Font("SansSerif", Font.ROMAN_BASELINE, 20);
		
		nameLabel = new JLabel("Hello "+name+ ", here are some instructions for the Examination.");
		nameLabel.setBounds(30, 30, 700, 30);
		nameLabel.setFont(font);
		super.add(nameLabel);
		
		jt = new JTextArea("\n"+instruction1+"\n\n"+instruction5+"\n\n"+instruction2+"\n\n"+instruction3+"\n\n"+instruction4+"\n\n");
		jt.setFont(font);
		jt.setEditable(false);
		JScrollPane pane = new JScrollPane(jt);
		pane.setBounds(30, 70, 700, 400);
		super.add(pane);
		
		
		openExamination = new JButton("Proceed");
		openExamination.setBounds(350, 510, 100, 35);
		super.add(openExamination);
		openExamination.addActionListener(this);
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(3);
		
		

	}
	
	public static void main(String[] args) {
		
		InstructionsBeforeExam ins = new InstructionsBeforeExam();
		ins.showUI("Vedant", "C", "itsv3d4nt@gmail.com");
		
	}

	@Override
	public void actionPerformed(ActionEvent e1) {
		// TODO Auto-generated method stub
		if(e1.getSource() == openExamination) {
			super.dispose();
			SelectTopic stop = new SelectTopic();
			Examination exam = new Examination();
			
			exam.showUI(name1, topic, email);
		}
		
	}

}
