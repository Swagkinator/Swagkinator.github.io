import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class UserInterface2 extends JFrame implements ActionListener{

    private Container menu, playingscreen;
    private Container buttons;
    private Container titleScreen, age;

    private JLayeredPane menu;

    private JLabel title;
    private JTextField grade, question;
    private JButton enterGrade, yesbuton, nobutton, idkbutton, probbutton, probnotbuttoon;

    private Swagkinator genie;



    public UserInterface2(){

	this.setTitle("Swagkinator");
	this.setSize(700,200);
	this.setLocation(100,100);
	this.setDefaultCloseOpearation(EXIT_ON_CLOSE);

	genie = new Swagkinator(true);
















    }








    private class Menu extends JFrame implements ActionListener{







	public Menu(){

	    this.setTitle("Swagkinator!");
	    this.setSize(700,200);
	    this.setLocation(100,100);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);






	}










    }

















}