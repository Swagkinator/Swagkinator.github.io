import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class User extends JFrame implements ActionListener{

    private Swagkinator genie;

    private Container splashbuttons, titlecontainer; //splashscreen containers
    private JWindow splashScreen;
    private JLabel title;
    private JButton startbutton, helpbutton; //splash screen buttons

    private Container playingScreen;
    private Container buttons, swagkinatorcontainer;
    private JLabel swagkinatorsays, swagkinatortitle;
    private JTextField questionasked;
    private JButton yesbutton, nobutton, idkbutton, probbutton, probnotbutton;

    public User(){

	//	play();
	showSplashScreen();
	play();

    }

    public void showSplashScreen(){

	splashScreen = new JWindow();
	splashScreen.getContentPane();
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

	splashScreen.setBounds(500, 150, 300, 200);
	splashScreen.setVisible(true);

    }

    public void play(){
	this.setTitle("Swagkinator");
	this.setSize(700,300);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	genie = new Swagkinator(true);

	playingScreen = this.getContentPane();
	playingScreen.setLayout(new GridLayout(2,1));

	swagkinatortitle = new JLabel("Welcome To Swagkinator!", null, JLabel.CENTER);
	swagkinatorsays = new JLabel("Swagkinator says:", null, JLabel.CENTER);

	questionasked = new JTextField(50);

	yesbutton = new JButton("YES");

	nobutton = new JButton("NO");

	idkbutton = new JButton("I DON'T KNOW");

	buttons = new Container();
	buttons.setLayout(new FlowLayout());

	swagkinatorcontainer = new Container();
	swagkinatorcontainer.setLayout(new FlowLayout());

	swagkinatorcontainer.add(swagkinatortitle);
	swagkinatorcontainer.add(swagkinatorsays);
	swagkinatorcontainer.add(questionasked);

	buttons.add(yesbutton);
	buttons.add(nobutton);
	buttons.add(idkbutton);

	playingScreen.add(swagkinatorcontainer);
	playingScreen.add(buttons);

	playingScreen.setVisible(false);

    }


    public void actionPerformed(ActionEvent e){


	String action = e.getActionCommand();


	if(action.equals("startgame")){
	    splashScreen.setVisible(false);
	    playingScreen.setVisible(true);

	}







    }






}