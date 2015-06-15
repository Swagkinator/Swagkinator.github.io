import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class User2 extends JFrame implements ActionListener{

    private Container swag;

    private SwagScreen splashscreen;
    private PlayScreen playingscreen;



    public User2(){

	this.setTitle("Swagkinator");
	this.setSize(700,300);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	swag = this.getContentPane();

	swag.add(splashscreen);


    }





    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();

	if(splashscreen.isExit()){
	    swag.remove(splashscreen);
	    swag.add(playingscreen);

	}

    }






}