import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class UserInterface2 extends JFrame implements ActionListener{

    private Container splashscreen, helpscreen, playingscreen, guessscreen, inputguessscreen;
    private Container defaultPane;

    private Container akinator, buttons;
    private Container titleScreen, age;
    private Container splashscreenbutton;

    //private JLayeredPane splashscreen, playingscreen, guessscreen, inputguesscreen;

    private JLabel title, swagkinatorsays;
    private JLabel welcomeswagtitle;

    private JTextField grade, questionasked;

    private JButton startbutton, helpbutton;
    private JButton enterGrade, yesbutton, nobutton, idkbutton, probbutton, probnotbutton;

    private Swagkinator genie;



    public UserInterface2(){

	this.setTitle("Swagkinator");
	this.setSize(700,200);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	genie = new Swagkinator(true);
	title = new JLabel("Welcome to Swagkinator!", null, JLabel.CENTER);


	defaultPane = new JLayeredPane();
	defaultPane = this.getContentPane();
	defaultPane.setLayout(new GridLayout(2,1));
	
	welcomeswagtitle = new JLabel("Swagkinator", JLabel.CENTER);

	startbutton = new JButton("START");
	startbutton.setActionCommand("switchtogame");
	startbutton.addActionListener(this);

	helpbutton = new JButton("help");
	helpbutton.setActionCommand("gotohelp");
	helpbutton.addActionListener(this);

	splashscreenbutton = new Container();
	splashscreenbutton.setLayout(new FlowLayout());
	splashscreenbutton.add(startbutton);
	splashscreenbutton.add(helpbutton);


	defaultPane.add(welcomeswagtitle, 0);
	defaultPane.add(splashscreenbutton, 1);

    }




    public void play(){

	swagkinatorsays = new JLabel("Swagkinator says:", null, JLabel.CENTER);
	questionasked = new JTextField(50);
	

	//buttons 
	yesbutton = new JButton("YES");
	yesbutton.setActionCommand("answeryes");
	yesbutton.addActionListener(this);

	nobutton = new JButton("NO");
	nobutton.setActionCommand("answerno");
	nobutton.addActionListener(this);

	idkbutton = new JButton("I DON'T KNOW");
	idkbutton.setActionCommand("answeridk");
	idkbutton.addActionListener(this);

	probbutton = new JButton ("PROBABLY");
	probbutton.setActionCommand("answerprob");
	probbutton.addActionListener(this);

	probnotbutton = new JButton("PROBABLY NOT");
	probnotbutton.setActionCommand("answerprobnot");
	probnotbutton.addActionListener(this);

	akinator = new Container();
	akinator.setLayout(new FlowLayout());

	akinator.add(swagkinatorsays);
	akinator.add(questionasked);


	buttons = new Container();
	buttons.setLayout(new FlowLayout());

	buttons.add(yesbutton);
	buttons.add(nobutton);
	buttons.add(probbutton);
	buttons.add(probnotbutton);
	buttons.add(idkbutton);

	defaultPane.remove(welcomeswagtitle);
	defaultPane.remove(startbutton);

	defaultPane.add(akinator, 0);
	defaultPane.add(buttons, 1);

	defaultPane = this.getContentPane();

	//defaultPane.add(playingscreen,JLayeredPane.DEFAULT_LAYER);


    }

    public void setSplashScreen(){

	splashscreen = new JLayeredPane();
	splashscreen.setLayout(new GridLayout(2,1));


    }


    public void setHelpScreen(){
    }


    public void setGuessScreen(){
    }



    public void actionPerformed(ActionEvent e){

	String action = e.getActionCommand();

	if(action.equals("switchtogame")){
		play();
	}

	if(action.equals("answeryes")){
	    questionasked.setText(genie.getNextQuestion());
	    genie.sendAnswerToNextQuestion("1.00");
	}

	if(action.equals("answerno")){
	    questionasked.setText(genie.getNextQuestion());
	    genie.sendAnswerToNextQuestion("0.0");
	}

	if(action.equals("answeridk")){
	    questionasked.setText(genie.getNextQuestion());
	    genie.sendAnswerToNextQuestion("0.50");

	}

    }



}