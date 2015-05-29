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
	    writeWithFilename(data.substring(5,data.length()));
	    return null;
	}else if(data.substring(0,4).equals("READ")){
	    return readWithFilename(data.substring(5,data.length()));
	}else{
	    throw new IllegalArgumentException("Instrucions not found");
	}
    }
    private int findLineBreak(String data){
	int x=0;
	for(;x<data.length()-1;x++){
	    //System.out.println(data.substring(x,x+1));
	    if(data.substring(x,x+1).equals("\n")){
		break;
	    }
	}
	return x;
    }
    private void writeWithFilename(String data){
	int lineBreak = findLineBreak(data);
	//System.out.println(lineBreak);
	writeOut(data.substring(0,lineBreak+1),data.substring(lineBreak+2,data.length()));
    }
    private String readWithFilename(String data){
	return "this is the contents of the file you inquired about\n ;) I promise";
    }

    public static void main(String[]args){
	fileWriter myFileWriter = new fileWriter();
	myFileWriter.recieve("WRIT testfile\nthis is the contents of a new file");
    }

}
