import java.util.*;
import java.io.*;

public class MyFileReader{ //needed to read data and questions

    private static final String questionFile = "questions.txt";
    private static final String teacherFile = "teachers.txt";
    private static final String dataFile = "data.txt";


    public static String[] getQuestionArray(String filePath){

	int size = 0;
	ArrayList<String> temp;
	String[] questions;

	try{

	    File file = new File(filePath);
	    Scanner in = new Scanner(file);
	    
	    temp = new ArrayList<String>();

	    while(in.hasNextLine()){
		temp.add(in.nextLine());
	    }

	    questions = new String[temp.size()];

	    for(int index = 0; index < temp.size(); index++){
		questions[index] = temp.get(index);
	    }	        

	}catch(FileNotFoundException e){ 
	    questions = new String[0];
	}

	return questions;

    }


    public static String[] getTeacherArray(String filePath){

	int size = 0;
	ArrayList<String> temp;
	String[] teachers;

	try{

	    File file = new File(filePath);
	    Scanner in = new Scanner(file);

	    temp = new ArrayList<String>();

	    while(in.hasNextLine()){
		temp.add(in.nextLine());
	    }

	    teachers = new String[temp.size()];

	    for(int index = 0; index < temp.size(); index++){
		teachers[index] = temp.get(index);

	    }

	}
	catch(FileNotFoundException e){
	    teachers = new String[0];
	}

	return teachers;

    }

    public static char[][] getDataArray(String filePath){

  
	ArrayList<String> temp;
	char[][] data;


	try{

	    File file = new File(filePath);
	    Scanner in = new Scanner(file);

	    temp = new ArrayList<String>();

	    //creates an arraylist of each line 
	    while(in.hasNextLine()){
		temp.add(in.nextLine());
	    }


	    data = new char[temp.size()][temp.get(0).length()/2];

	    for(int i = 0; i< temp.size(); i++){
		String str = temp.get(i);
		for(int j = 0; j < str.length() /2; j++){
		    data[i][j] = str.charAt(j*2);
		}
	    }

	}catch(FileNotFoundException e){
	    data = new char[0][0];
	}

	return data;
    }


}