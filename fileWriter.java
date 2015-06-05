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
    
    public String recieve(String data) throws IOException{
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
	    if(data.substring(x,x+1).equals("+")){
		break;
	    }
	}
	return x;
    }
    private void writeWithFilename(String data){
	int lineBreak = findLineBreak(data);
	//System.out.println(lineBreak);
	data = findAndReplace(data,'\n','\\');
	writeOut(data.substring(0,lineBreak),data.substring(lineBreak+1,data.length()));
    }

    //stolen from stack overflow
    private String readFile( String file ) throws IOException {
	try{
	    BufferedReader reader = new BufferedReader( new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");
	    
	    while( ( line = reader.readLine() ) != null ) {
		stringBuilder.append( line );
		stringBuilder.append( ls );
	    }	
	    return stringBuilder.toString();
	}catch(IOException e){
	    e.printStackTrace();
	}
	return null;
    }//end of stolen code
    
    private String readWithFilename(String data) throws IOException{
	return findAndReplace(readFile(data),'\n','\\');
    }

    public String findAndReplace(String data, char find, char replace){
	//Builds a new string to optomize runtime and not create a new string every time a character needs to be changed
	String ans = "";
	for(int x=0;x<data.length();x++){
	    if(data.charAt(x) == find){
		ans+=replace;
	    }
	    else{
		ans+= data.charAt(x);
	    }
	}
	return ans;
    }
    
    /*public static void main(String[]args){
	//fileWriter myFileWriter = new fileWriter();

	//myFileWriter.recieve("WRIT testfile\nthis is the contents of a new file");
	String mine =  "abcd\nefgh";
	fileWriter here = new fileWriter();
	System.out.println(here.findAndReplace(mine,'\n','+'));
	}*/
    
}
