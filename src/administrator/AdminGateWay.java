package administrator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AdminGateWay extends JFrame implements ActionListener {
	
	JButton addtopic, deleteTopic, addQuestion, deleteQuestions, viewStudent, provideAssist, 
			approveCompany, disapproveCompany, approveFeedback;
	
	
	public void showUI() {
		
		super.setTitle("Administrator Gateway");
		super.getContentPane().setBackground(Color.decode("#03F"));
		super.setBounds(300, 20, 400, 680);
		super.setResizable(false);
		
		addtopic = new JButton("ADD A TOPIC");
		addtopic.setBounds(50, 20, 300, 50);
		super.add(addtopic);
		
		deleteTopic = new JButton("DELETE A TOPIC");
		deleteTopic.setBounds(50, 90, 300, 50);
		super.add(deleteTopic);
		
		addQuestion = new JButton("ADD A QUESTION");
		addQuestion.setBounds(50, 160, 300, 50);
		super.add(addQuestion);
		
		deleteQuestions = new JButton("DELETE A QUESTION");
		deleteQuestions.setBounds(50, 230, 300, 50);
		super.add(deleteQuestions);
		
		viewStudent = new JButton("VIEW STUDENT");
		viewStudent.setBounds(50, 300, 300, 50);
		super.add(viewStudent);
		
		provideAssist = new JButton("PROVIDE ASSISSTANCE");
		provideAssist.setBounds(50, 370, 300, 50);
		super.add(provideAssist);
		
		approveCompany = new JButton("APPROVE A COMPANY");
		approveCompany.setBounds(50, 440, 300, 50);
		super.add(approveCompany);
		
		disapproveCompany = new JButton("DISAPPROVE A COMPANY");
		disapproveCompany.setBounds(50, 510, 300, 50);
		super.add(disapproveCompany);
		
		approveFeedback = new JButton("FEEDBACK APPROVAL");
		approveFeedback.setBounds(50, 580, 300, 50);
		super.add(approveFeedback);
		
		addQuestion.addActionListener(this);
		deleteTopic.addActionListener(this);
		addtopic.addActionListener(this);
		
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		
		AdminGateWay gateWay = new AdminGateWay();
		gateWay.showUI();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == addtopic) {
			super.dispose();
			AddTopic at = new AddTopic();
			at.showUI();
		}
		
		if(e.getSource() == addQuestion) {
			super.dispose();
			AddQuestions aq = new AddQuestions();
			aq.showUI();
		}
		
		if(e.getSource() == deleteTopic) {
			super.dispose();
			DeleteTopic at = new DeleteTopic();
			at.showUI();
		}
		
		
	}

}
