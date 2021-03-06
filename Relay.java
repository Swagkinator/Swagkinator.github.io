import java.util.*;
import java.io.*;
import java.net.*;

public class Relay{ //class that relays data between client and server
    private final String serverAddress = "45.55.195.173"; //IP adress for server
    //private final String serverAddress = "127.0.0.1"; //IP adress for server
    //private final String serverAddress = "92.242.140.21"; //IP adress for server
    private final int port = 8005; // Port to connect to server with
    private fileWriter myFileWriter;
    
    Socket serverSocket = null; // Sets up the socket, out and in variables
    PrintWriter out = null;
    BufferedReader in = null;
    
    public Relay(){
	myFileWriter = new fileWriter();
	//Code stolen from Rodda's networking demo
	try {
	    serverSocket = new Socket(serverAddress, port); // Connects to the server on the address and the port
	    out = new PrintWriter(serverSocket.getOutputStream(), true); // Creates the streams
	    in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
	}
	catch (UnknownHostException e) {
	    e.printStackTrace(); // Exception handling
	    	}
	catch (IOException e) {
	    e.printStackTrace(); // Excpetion handling
	}
	//End of stolen code
    }
    
    public String retrieve(String filename){ //retrieves the string at filename on the server side
	try{
	    out.println("READ "+filename);
	    return myFileWriter.findAndReplace(in.readLine(),'\\','\n');
	}catch(IOException e){
	    e.printStackTrace();
	}
	return "";
    } 
    
    public void writeToFile(String filename, String newContents){
	newContents = myFileWriter.findAndReplace(newContents,'\n','\\');
	out.println("WRIT "+filename+"+"+newContents);
    }
}
