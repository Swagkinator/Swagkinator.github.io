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
    private JButton enterGrade, yesbutton, nobutton, idkbutton;

    private static final int menuMode = 0;
    private static final int playingMode = 1;

    private int mode;


    public UserInterface(int m){

	//pane = this.getContentPane();
	//GroupLayout layout = new GroupLayout(pane);

	this.setTitle("Swagkinator!");
	this.setSize(600,600);
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
	yesbutton = new JButton("YES");
	nobutton = new JButton("NO");
	idkbutton = new JButton("I DON'T KNOW");

	akinator = new Container();
	akinator.setLayout(new FlowLayout());

	akinator.add(swagkinator);
	akinator.add(question);

	buttons = new Container();
	buttons.setLayout(new FlowLayout());

	buttons.add(yesbutton);
	buttons.add(nobutton);
	buttons.add(idkbutton);

	playingscreen.add(akinator);
	playingscreen.add(buttons);

	//pane.add(swagkinator);
      	//pane.add(yesbutton);
	//pane.add(nobutton);
	//pane.add(idkbutton);
	}
    }

    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();
	if(action.equals("switchToGame")){
		mode = playingMode;
	    }


    }



}

















