import java.util.*;
import java.io.*;
import java.net.*;

public class Relay{ //class that relays data between client and server
    private final Sting serverAdress = "127.0.0.1"; //IP adress for server
    private final int port = 8005; // Port to connect to server with
    
    Socket serverSocket = null; // Sets up the socket, out and in variables
    PrintWriter out = null;
    BufferedReader in = null;
    
    public Relay(){
	//Code stolen from Rodda's networking demo

	try {
	    serverSocket = new Socket(serverAddress, port); // Connects to the server on the address and the port
	    out = new PrintWriter(serverSocket.getOutputStream(), true); // Creates the streams
	    in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
	}
	catch (UnknownHostException e) {
	    e.printStackTrace(); // Exception handling
	    return false;
	}
	catch (IOException e) {
	    e.printStackTrace(); // Excpetion handling
	    return false;
	}
	//End of stolen code
    }
    
    public String retrieve(String filename){ //retrieves the string at filename on the server side
	out.println("READ "+filename);
	return in.readLine();
    } 
    
    public void writeToFile(String filename, String newContents){
	out.println("WRIT "+filename+"\n"+newContents);
    }
}
