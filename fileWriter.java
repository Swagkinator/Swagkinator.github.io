import java.io.*;
public class fileWriter{
    
    private void writeOut(String filename, String content){
	try{
	    PrintWriter writer = new PrintWriter(filename, "UTF-8");
	    writer.println(content);
	    writer.close();
	}catch(IOException e){
	    e.printStackTrace();
	}
    }
    
    public String recieve(String data){
	if(data.substring(0,4).equals("WRIT")){
	    writeWithFilename(data.substring(4,data.length()));
	    return null;
	}else if(data.substring(0,4).equals("READ")){
	    return readWithFilename(data.substring(4,data.length()));
	}else{
	    throw new IllegalArguementException("Instrucions not found");
	}
    }
    private int findLineBreak(String data){
	for(int x=0;
    }
    private void writeWithFilename(String data){
	
    }
    private String readWithFilename(String data){
	
    }

}
