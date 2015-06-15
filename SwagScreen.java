import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SwagScreen extends JPanel implements ActionListener{

    private Container splashbuttons, titlecontainer; //splashscreen containers
    private JPanel splashScreen;
    private JLabel title;
    private JButton startbutton, helpbutton; //splash screen buttons

    private boolean exit;

    public SwagScreen(){

	exit = false;

	this.setLayout(new GridLayout(2,1));

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


	this.add(titlecontainer);
	this.add(splashbuttons);

	//splashScreen.setBounds(500, 150, 300, 200);
	this.setVisible(true);




    }


    public boolean isExit(){
	return exit;

    }


    public void actionPerformed(ActionEvent e){


	String action = e.getActionCommand();

	if(action.equals("startgame")){
	    //this.remove(SwagScreen);

	    exit = true;
	}


    }



}