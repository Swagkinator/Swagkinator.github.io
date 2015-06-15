import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class PlayScreen extends JPanel implements ActionListener{


    private JPanel playingScreen;
    private Container answerbuttons, swagkinatorcontainer;
    private JLabel swagkinatorsays, swagkinatortitle;
    private JTextField questionasked;
    private JButton yesbutton, nobutton, idkbutton, probbutton, probnotbutton;

    private Swagkinator genie;


    public PlayScreen(){

	genie = new Swagkinator(true);

	this.setLayout(new GridLayout(2,1));

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

	this.add(swagkinatorcontainer);
	this.add(answerbuttons);

	this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){


	String action = e.getActionCommand();

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