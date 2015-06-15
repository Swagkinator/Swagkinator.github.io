import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class GuessScreen extends JPanel implements ActionListener{


    private Container guesscontainer, buttoncontainer;

    private JLabel guessquestion;
    private JTextField swagkinatorguess;
    private JButton yesbutton, nobutton;


    public GuessScreen(Swagkinator genie){

	this.setLayout(new GridLayout(2,1));

	guessquestion = new JLabel("Is this your teacher?", null, JLabel.CENTER);
	swagkinatorguess = new JTextField(30);

	yesbutton = new JButton("YES, YOU ARE BRILLIANT");
	yesbutton.setActionCommand("correct");
	yesbutton.addActionListener(this);

	nobutton = new JButton("NO, YOU ARE WRONG");
	nobutton.setActionCommand("incorrect");
	nobutton.addActionListener(this);

	guesscontainer = new Container();
	guesscontainer.setLayout(new FlowLayout());
	buttoncontainer = new Container();
	buttoncontainer.setLayout(new FlowLayout());

	guesscontainer.add(guessquestion);
	guesscontainer.add(swagkinatorguess);

	buttoncontainer.add(yesbutton);
	buttoncontainer.add(nobutton);

	this.add(guesscontainer);
	this.add(buttoncontainer);



    }



    public void actionPerformed(ActionEvent e){

	String action = e.getActionCommand();




    }







}