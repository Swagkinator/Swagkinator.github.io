import java.util.*;
import java.io.*;

public class MyFileReader{ //needed to read data and questions

    private static final String questionFile = "questions.txt";
    private static final String teacherFile = "teachers.txt";
    private static final String dataFile = "data.txt";


    /*
    private String[] questions, teachers;
    private char[][] data; 
    private String filePath;
    private File file;

    private boolean isArray;

    
    public MyFileReader(File f){

	String fileName = f.getPath();

	if(fileName.equals(questionFile) || fileName.equals(teacherFile)){
	    isArray = true;
	}
	if(fileName.equals(dataFile)){
	    isArray = false;
	}

	try{

	    int size1 = 0;
	    int size2 = 0;

	    Scanner in = new Scanner(file);
	    while(in.hasNextLine()){
		size1++;
	    }

	    if(isArray){
		if(fileName.equals(questionFile)){
		    questions = new String[size1];
		}else{
		    teachers = new String[size1];   
		}
	    }else{
		String str = in.nextLine();
		size2 = (int) str.length();
		data = new char[size1][size2];
	    }
	}
	catch(FileNotFoundException e){}
	
	   
	filePath = fileName;
	file = f;
	
    }
    

    //scans through file    
     
   public void read(){
   try{
   Scanner in = new Scanner (filePath);
       
   
   }
   catch(FileNotFoundException e){}
    }
    */



    public static String[] getQuestionArray(String filePath){

	int size = 0;
	String[] questions;

	try{

	    File file = new File(filePath);

	    Scanner in = new Scanner(file);
	    
	    while(in.hasNextLine()){
		size++;
	    }

	    questions = new String[size];

	    
	    for(int i = 0; i < questions.length; i++){
		String q = in.nextLine();
		questions[i] = q;
	    }
	        
	}catch(FileNotFoundException e){ 
	    questions = new String[0];
	}

	return questions;

    }


    public static String[] getTeacherArray(String filePath){

	int size = 0;
	String[] teachers;


	try{

	    File file = new File(filePath);

	    Scanner in = new Scanner(file);

	    while(in.hasNextLine()){
		size++;
	    }

	    teachers = new String[size];

	    for(int i=0; i<teachers.length; i++){
		String q = in.nextLine();
		teachers[i] = q;

	    }

	}
	catch(FileNotFoundException e){
	    teachers = new String[0];
	}

	return teachers;

    }

    public static char[][] getDataArray(String filePath){

	int size1 = 0;
	int size2 = 0;
	String str = "";
	char[][] data;


	try{

	    File file = new File(filePath);

	    Scanner in = new Scanner(file);


	    while(in.hasNextLine()){
		if(size1 == 0){
		    str = in.nextLine();
		}
		size1++;
	    }

	    size2 = (int) str.length() / 2;


	    data = new char[size1][size2];

	    for(int i=0; i<data.length; i++){
		String answer = in.nextLine();
		for(int j=0; j< (int)data[0].length/2; j++){
		    char ans =  answer.charAt(j *2);
		    data[i][j] = ans;
		}
		
	    }

	}catch(FileNotFoundException e){
	    data = new char[0][0];
	}

	return data;
    }


}