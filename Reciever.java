import java.util.*;
import java.io.*;
import java.net.*;

public class Reciever{
    private ArrayList<ClientHandlingThread> threads;
    private ServerSocket socket;
    
    public Reciever(){
	//Code stolen from Rodda's networking demo
	socket = null;
	threads = new ArrayList<ClientHandlingThread>(); // This is an array list containing all of the threads for handling the clients/
	
	try {
	    socket = new ServerSocket(30000); // This intantiates the socket
	}
	catch (IOException e) {
	    e.printStackTrace(); // Exception handling
	}
	//end of stolen code
    }
    
        
    public static void main(String[]args){
	//More stolen code from Rodda
	while (1 == 1) { // The infinite loop dealing with accepting clients and starting the threads
	    try {
		client = socket.accept(); // This essentially accepts a connection from a client
		ClientHandlingThread c = new ClientHandlingThread(client); // This creates a thread to deal with this client
		c.start(); // This starts the thread
		threads.add(c); // This adds the thread to the array list
	    }
	    catch (IOException e) {
		e.printStackTrace(); // Exception handling
	    }
	}
    }

    //Mostly stolen class that handles data transfer
    private class ClientHandlingThread extends Thread { // This is the handling thread
	private Socket socket = null; // This is the socket that is passed in.

	public ClientHandlingThread(Socket s) { // Very simple constructor
	    super("Server Thread");
	    this.socket = s;
	}

	public void run() {
	    try {
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // Creates the writer so that we can write to the server
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Creates the input stream so that we can get input from the server
		
		String inputLine; // This will be the input from the server

		while ((inputLine = in.readLine()) != null) { //loops every time new input is recieved
		    recieve(inputLine);
		    //Do stuff
		}
		socket.close(); // If we are out of the loop we will close all of our streams
		out.close();
		in.close();
	    }
	    catch (IOException e) {
		e.printStackTrace(); // Exception handling
	    }
	}
	//end of (mostly) stolen code

	public void recieve(String input){
	    System.out.println("recieved data from server as follows: \n"+input);
	}
       
    }
    
}
