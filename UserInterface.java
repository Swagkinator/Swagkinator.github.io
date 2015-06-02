import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class UserInterface extends JFrame{

    private Container pane;
    private Container buttons, akinator;
    private JLabel swagkinator;
    private JTextField question;
    private JButton yesbutton, nobutton, idkbutton;

    public UserInterface(){

	//pane = this.getContentPane();
	//GroupLayout layout = new GroupLayout(pane);

	this.setTitle("Swagkinator!");
	this.setSize(600,100);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new GridLayout(2,1));

	swagkinator = new JLabel("Swag-kinator says:", null, JLabel.CENTER);
	question = new JTextField(50);
	yesbutton = new JButton("YES");
	nobutton = new JButton("NO");
	idkbutton = new JButton("I DON'T KNOW");

	akinator = new Container();
	akinator.setLayout(new FlowLayout());

	akinator.add(swagkinator);
	akinator.add(question);

	buttons = new Container();
	buttons.setLayout(new FlowLayout());

	buttons.add(yesbutton);
	buttons.add(nobutton);
	buttons.add(idkbutton);

	pane.add(akinator);
	pane.add(buttons);

	//pane.add(swagkinator);
      	//pane.add(yesbutton);
	//pane.add(nobutton);
	//pane.add(idkbutton);
    }


}

















