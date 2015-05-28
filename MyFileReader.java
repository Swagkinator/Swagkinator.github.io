import java.util.*;
import java.io.*;

public class MyFileReader{ //needed to read data and questions

    private static final String questionFile = "questions.txt";
    private static final String teacherFile = "teachers.txt";
    private static final String dataFile = "data.txt";

    private String[] questions, teachers;
    private int[][] data;
    private String filePath;

    private boolean isArray;


    public MyFileReader(String fileName){
	if(fileName.equals(questionFile) || fileName.equals(teacherFile)){
	    isArray = true;
	}
	if(fileName.equals(dataFile)){
	    isArray = false;
	}

	filePath = fileName;


		
    }
	

    //scans through file    
    public void read(){
	try{
	Scanner in = new Scanner (filePath);
       
	
	}
    }
    

    public int[] QuestionArray(){

	try{
	    Scanner in = new Scanner(filePath);
	    int size = 0;

	    while(in.hasNextLine()){
	        size++;
	    }

	    questions = new Stirng[size];

	    for(int i = 0; i < size; i++){
		question[i] = in.nextLine();
	    }
	    
	}
	catch(FileNotFoundException e){	}

    }


    public int[] TeacherArray(){



    }

    public int[][] DataArray(){

    }



}