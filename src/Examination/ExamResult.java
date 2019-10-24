package Examination;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ExamResult extends JFrame implements ActionListener {
	
	JLabel 	resultLabel, scoreLabel, percentLabel,
			ques, ques1, ques2, ques3, ques4, ques5, ques6, ques7, ques8, ques9, ques10,
			userSelected, correctOption;
	
	
	public void showUI(String[] userResponse, String[] corectOptions, double score) {
		
		Font font = new Font("SansSerif", Font.ROMAN_BASELINE, 14);
		Font font1 = new Font("SansSerif", Font.BOLD, 17);
		int i = 0;
		super.setTitle("View Result");
		super.setBounds(300, 30, 410, 600);
		super.setResizable(false);
		
		resultLabel = new JLabel("RESULT");
		resultLabel.setFont(font1);
		resultLabel.setBounds(160, 5, 200, 30);
		super.add(resultLabel);
		
		userSelected = new JLabel("•Your Response");
		userSelected.setFont(font);
		userSelected.setBounds(135, 45, 120, 25);
		super.add(userSelected);
		
		ques = new JLabel("•Question No");
		ques.setFont(font);
		ques.setBounds(20, 45, 100, 25);
		super.add(ques);
		
		correctOption = new JLabel("•Correct Option");
		correctOption.setFont(font);
		correctOption.setBounds(270, 45, 125, 25);
		super.add(correctOption);
		
		ques1 = new JLabel("Q1                            "+ userResponse[i].toUpperCase()+"                                " + corectOptions[i++].toUpperCase());
		ques1.setBounds(50, 90, 350, 25);
		ques1.setFont(font);
		super.add(ques1);
		
		ques2 = new JLabel("Q2                            "+ userResponse[i].toUpperCase()+"                                " + corectOptions[i++].toUpperCase());
		ques2.setBounds(50, 130, 350, 25);
		ques2.setFont(font);
		super.add(ques2);
		
		ques3 = new JLabel("Q3                            "+ userResponse[i].toUpperCase()+"                                " + corectOptions[i++].toUpperCase());
		ques3.setBounds(50, 170, 350, 25);
		ques3.setFont(font);
		super.add(ques3);
		
		ques4 = new JLabel("Q4                            "+ userResponse[i].toUpperCase()+"                                " + corectOptions[i++].toUpperCase());
		ques4.setBounds(50, 210, 350, 25);
		ques4.setFont(font);
		super.add(ques4);
		
		ques5 = new JLabel("Q5                            "+ userResponse[i].toUpperCase()+"                                " + corectOptions[i++].toUpperCase());
		ques5.setBounds(50, 250, 350, 25);
		ques5.setFont(font);
		super.add(ques5);
		
		ques6 = new JLabel("Q6                            "+ userResponse[i].toUpperCase()+"                                " + corectOptions[i++].toUpperCase());
		ques6.setBounds(50, 290, 350, 25);
		ques6.setFont(font);
		super.add(ques6);
		
		ques7 = new JLabel("Q7                            "+ userResponse[i].toUpperCase()+"                                " + corectOptions[i++].toUpperCase());
		ques7.setBounds(50, 330, 350, 25);
		ques7.setFont(font);
		super.add(ques7);
		
		ques8 = new JLabel("Q8                            "+ userResponse[i].toUpperCase()+"                                " + corectOptions[i++].toUpperCase());
		ques8.setBounds(50, 370, 350, 25);
		ques8.setFont(font);
		super.add(ques8);
		
		ques9 = new JLabel("Q9                            "+ userResponse[i].toUpperCase()+"                                " + corectOptions[i++].toUpperCase());
		ques9.setBounds(50, 410, 350, 25);
		ques9.setFont(font);
		super.add(ques9);
		
		ques10 = new JLabel("Q10                          "+ userResponse[i].toUpperCase()+"                                " + corectOptions[i++].toUpperCase());
		ques10.setBounds(50, 450, 350, 25);
		ques10.setFont(font);
		super.add(ques10);
		
		scoreLabel = new JLabel("You Scored : " + score);
		scoreLabel.setBounds(35, 500, 150, 25);
		scoreLabel.setFont(font1);
		super.add(scoreLabel);
		
		
		percentLabel = new JLabel("Percentage : " + (score)*10);
		percentLabel.setBounds(205, 500, 150, 25);
		percentLabel.setFont(font1);
		super.add(percentLabel);
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(3);
		
	}
	
	public static void main(String[] args) {
		
		ExamResult er = new ExamResult();
		String[] fake = {"a","b" ,"c" ,"a" ,"d" ,"c" ,"d" ,"b" ,"a" ,"d"};
		er.showUI(fake, fake, 8.25);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}
	
	

}
