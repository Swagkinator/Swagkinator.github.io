import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class UserInterface extends JFrame{

    private Container pane;
    private JLabel swaginator;
    private JButton yesbutton, nobutton, idkbutton;

    public UserInterface(){

	pane = this.getContentPane();


	GroupLayout layout = new GroupLayout(pane);

	this.setTitle("Swagkinator!");
	this.setSize(600,100);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane.setLayout(layout);

	layout.setAutoCreateGaps(true);
	layout.setAutoCreateContainerGaps(true);

	//swagkinator = new JLabel("Swag-kinator says:");
	yesbutton = new JButton("YES");
	nobutton = new JButton("NO");
	idkbutton = new JButton("I DON'T KNOW");
	
	
	layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					  .addComponent(yesbutton)
					  .addComponent(nobutton)
					  .addComponent(idkbutton)
					  )
				);


	//pane.add(swagkinator);
      	//pane.add(yesbutton);
	//pane.add(nobutton);
	//pane.add(idkbutton);
    }


}

















