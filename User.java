
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class User extends JFrame implements ActionListener{

    private Swagkinator genie;

    private Container splashbuttons, titlecontainer; //splashscreen containers
    private Container splashScreen;
    private JLabel title;
    private JButton startbutton, helpbutton; //splash screen buttons

    private JFrame playingScreen;
    private Container answerbuttons, swagkinatorcontainer;
    private JLabel swagkinatorsays, swagkinatortitle;
    private JTextField questionasked;
    private JButton yesbutton, nobutton, idkbutton, probbutton, probnotbutton;

    public User(){

	//	play();
	showSplashScreen();
 

    }

    public void showSplashScreen(){

	this.setTitle("Welcome to Swagkinator!");
	this.setSize(700,200);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	splashScreen = new Container();
	splashScreen = 	this.getContentPane();
	splashScreen.setLayout(new GridLayout(2,1));


	title = new JLabel("SWAGKINATOR", null, JLabel.CENTER);
	
	startbutton = new JButton("START");
	startbutton.setActionCommand("startgame");
	startbutton.addActionListener(this);

	helpbutton = new JButton("HELP");
	helpbutton.setActionCommand("help");
	helpbutton.addActionListener(this);

	splashbuttons = new Container();
	splashbuttons.setLayout(new FlowLayout());
	splashbuttons.add(startbutton);
	splashbuttons.add(helpbutton);

	titlecontainer = new Container();
	titlecontainer.setLayout(new FlowLayout());
	titlecontainer.add(title);


	splashScreen.add(titlecontainer);
	splashScreen.add(splashbuttons);

	//splashScreen.setBounds(500, 150, 300, 200);
	splashScreen.setVisible(true);

    }

    public void play(){
	this.setTitle("Swagkinator");
	this.setSize(700,300);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	genie = new Swagkinator();

	//playingScreen = this.getContentPane();
	playingScreen.setLayout(new GridLayout(2,1));

	swagkinatortitle = new JLabel("Welcome To Swagkinator!", null, JLabel.CENTER);
	swagkinatorsays = new JLabel("Swagkinator says:", null, JLabel.CENTER);

	questionasked = new JTextField(50);

	yesbutton = new JButton("YES");
	yesbutton.setActionCommand("answeryes");
	yesbutton.addActionListener(this);

	nobutton = new JButton("NO");
	nobutton.setActionCommand("answerno");
	nobutton.addActionListener(this);

	idkbutton = new JButton("I DON'T KNOW");
	idkbutton.setActionCommand("answeridk");
	idkbutton.addActionListener(this);

	probbutton = new JButton("PROBABLY");
	probbutton.setActionCommand("answerprob");
	probbutton.addActionListener(this);

	probnotbutton = new JButton("PROBABLY NOT");
	probnotbutton.setActionCommand("answerprobnot");
	probnotbutton.addActionListener(this);

	swagkinatorcontainer = new Container();
	swagkinatorcontainer.setLayout(new FlowLayout());

	answerbuttons = new Container();
	answerbuttons.setLayout(new FlowLayout());

	//swagkinatorcontainer.add(swagkinatortitle);
	swagkinatorcontainer.add(swagkinatorsays);
	swagkinatorcontainer.add(questionasked);

	answerbuttons.add(yesbutton);
	answerbuttons.add(nobutton);
	answerbuttons.add(probbutton);
	answerbuttons.add(probnotbutton);
	answerbuttons.add(idkbutton);

	playingScreen.add(swagkinatorcontainer);
	playingScreen.add(answerbuttons);

	//playingScreen.setVisible(false);

    }


    public void showGuessScreen(){





    }


    public void actionPerformed(ActionEvent e){


	String action = e.getActionCommand();

       

	if(action.equals("startgame")){
	    splashScreen.setVisible(false);
	    play();
	    playingScreen.setVisible(true);

	}

	if(action.equals("answeryes")){
	    questionasked.setText(genie.getNextQuestion());
	    genie.sendAnswerToNextQuestion("1.00");
	}

	if(action.equals("answerno")){
	    questionasked.setText(genie.getNextQuestion());
	    genie.sendAnswerToNextQuestion("0.00");
	}

	if(action.equals("answerprob")){
	    questionasked.setText(genie.getNextQuestion());
	    genie.sendAnswerToNextQuestion("0.75");
	}


	if(action.equals("answerprobnot")){
	    questionasked.setText(genie.getNextQuestion());
	    genie.sendAnswerToNextQuestion("0.25");
	}

	if(action.equals("answeridk")){
	    questionasked.setText(genie.getNextQuestion());
	    genie.sendAnswerToNextQuestion("0.50");
	}


	if(!genie.hasNextQuestion()){
	    questionasked.setText(genie.getBestGuess().toString());
	}



    }






}