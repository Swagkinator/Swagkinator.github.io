import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class User2 extends JFrame implements ActionListener{

    private Container swag;

    private SwagScreen splashscreen;
    private PlayScreen playingscreen;
    private GuessScreen guessscreen;

    public Swagkinator genie;

    public User2(){

	this.setTitle("Swagkinator");
	this.setSize(700,200);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	genie = new Swagkinator(true);

	swag = this.getContentPane();

	splashscreen = new SwagScreen();
	playingscreen = new PlayScreen(genie);
	guessscreen = new GuessScreen(genie);

	swag.add(splashscreen);

    }


    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();

	if(splashscreen.isExit()){

	    swag.remove(splashscreen);
	    //splashscreen.setVisible(false);
	    swag.add(playingscreen);
	    swag.revalidate();
	    swag.repaint();

	}



    }


}