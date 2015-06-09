import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class UserInterface extends JFrame implements ActionListener{

    private Container menu, playingscreen;
    private Container buttons, akinator;
    private Container titleScreen, grade;

    private JLabel title, age, swagkinator;
    private JTextField gradeLevel, question;
    private JButton enterGrade, yesbutton, nobutton, idkbutton, probbutton, probnotbutton;

    private String[] questions;
    private String[] teachers;

    private Swagkinator genie;

    private static final int menuMode = 0; //starting screen
    private static final int playingMode = 1; //playing screen

    private int mode;
    private int questionCounter;

    public UserInterface(int m){

	//pane = this.getContentPane();
	//GroupLayout layout = new GroupLayout(pane);

	this.setTitle("Swagkinator!");
	this.setSize(700,200);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	mode = m;

	if(mode == menuMode){
	    menu = this.getContentPane();
	    menu.setLayout(new GridLayout(2,1));

	    title = new JLabel("Welcome to Swagkinator!", null, JLabel.CENTER);
	    age = new JLabel("What is your grade level?", null, JLabel.CENTER);
	    gradeLevel = new JTextField();
	    enterGrade = new JButton("Proceed to game");

	    enterGrade.setActionCommand("switchToGame");
	    enterGrade.addActionListener(this);

	    titleScreen = new Container();
	    titleScreen.setLayout(new FlowLayout());

	    grade = new Container();
	    grade.setLayout(new FlowLayout());

	    titleScreen.add(title);
	    titleScreen.add(age);

	    grade.add(gradeLevel);
	    grade.add(enterGrade);

	    menu.add(titleScreen);
	    menu.add(grade);

	}

	if(mode == playingMode){
	playingscreen = this.getContentPane();
	playingscreen.setLayout(new GridLayout(2,1));

	swagkinator = new JLabel("Swag-kinator says:", null, JLabel.CENTER);
	question = new JTextField(50);

	//yes button
	yesbutton = new JButton("YES");
	yesbutton.setActionCommand("answeryes");
	yesbutton.addActionListener(this);

	//no button
	nobutton = new JButton("NO");
	nobutton.setActionCommand("answerno");
	nobutton.addActionListener(this);

	//idk button
	idkbutton = new JButton("I DON'T KNOW");
	idkbutton.setActionCommand("answeridk");
	idkbutton.addActionListener(this);

	//probably button
	probbutton = new JButton("PROBABLY");
	probbutton.setActionCommand("answerprob");
	probbutton.addActionListener(this);

	//probably not button
	probnotbutton = new JButton("PROBABLY NOT");
	probnotbutton.setActionCommand("ansprobnot");
	probnotbutton.addActionListener(this);

	akinator = new Container();
	akinator.setLayout(new FlowLayout());

	akinator.add(swagkinator);
	akinator.add(question);

	buttons = new Container();
	buttons.setLayout(new FlowLayout());

	buttons.add(yesbutton);
	buttons.add(nobutton);
	buttons.add(probbutton);
	buttons.add(probnotbutton);
	buttons.add(idkbutton);

	playingscreen.add(akinator);
	playingscreen.add(buttons);

	//pane.add(swagkinator);
      	//pane.add(yesbutton);
	//pane.add(nobutton);
	//pane.add(idkbutton);
	}

	questions = MyFileReader.getQuestionArray();
	teachers = MyFileReader.getTeacherArray();
	genie = new Swagkinator();

    }


    //public void setLogin(){}


    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();

	if(action.equals("switchToGame")){
		mode = playingMode;
	    }


	if(action.equals("answeryes")){
	    question.setText(genie.getNextQuestion());
	    genie.sendAnswerToNextQuestion("1.00");
	}

	if(action.equals("answerno")){
	    question.setText(genie.getNextQuestion());
	    genie.sendAnswerToNextQuestion("0.0");
	}

	if(action.equals("answeridk")){
	    question.setText(genie.getNextQuestion());
	    genie.sendAnswerToNextQuestion("0.5");
	}

	if(action.equals("answerprob")){
	    question.setText(genie.getNextQuestion());
	    genie.sendAnswerToNextQuestion("0.75");
	}

	if(action.equals("answerprobnot")){
	    question.setText(genie.getNextQuestion());
	    genie.sendAnswerToNextQuestion("0.25");
	}


    }



}

