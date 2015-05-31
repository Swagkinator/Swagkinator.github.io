import java.util.*;
import java.io.*;
import java.swing.*;
import java.awt.event.*;
import java.awt.*;

public class UserInterface extends JFrame{

    private Container pane;
    private JButton yesbutton, nobutton, idkbutton;

    public UserInterface{

	this.setTitle("Swagkinator!");
	this.setSize(600,100);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(FlowLayout());

	yesbutton = new JButton("YES!");
	nobutton = new JButton ("NO!");
	idkbutton - new JButton("I DON'T KNOW");

	pane.add(yesbutton);
	pane.add(nobutton);
	pane.add(idkbutton);
    }






    }

















}