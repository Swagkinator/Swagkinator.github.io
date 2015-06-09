import java.util.*;
import java.io.*;

public class MyFileReader{ //needed to read data and questions

    private static final String questionFile = "questions.txt";
    private static final String teacherFile = "teachers.txt";
    private static final String dataFile = "data.txt";
<<<<<<< HEAD

    public static String[] getQuestionArray(){

	return getQuestionArray(questionFile);

    }

    public static String[] getTeacherArray(){

	return getTeacherArray(teacherFile);

    }


=======
    
>>>>>>> 4c280fdac5204ba222db1d5b91cf8b1698a82d22
    public static String[] getQuestionArray(String filePath){

	int size = 0;
	ArrayList<String> temp;
	String[] questions;
	
	try{

	    File file = new File(filePath);
	    //Scanner in = new Scanner(file);
	    Scanner in = new Scanner(filePath);
	    
	    temp = new ArrayList<String>();

	    while(in.hasNextLine()){
		temp.add(in.nextLine());
	    }

	    questions = new String[temp.size()];

	    for(int index = 0; index < temp.size(); index++){
		questions[index] = temp.get(index);
	    }	        

	}catch(Exception e){ 
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
	    Scanner in = new Scanner(filePath);

	    temp = new ArrayList<String>();

	    while(in.hasNextLine()){
		temp.add(in.nextLine());
	    }

	    teachers = new String[temp.size()];

	    for(int index = 0; index < temp.size(); index++){
		teachers[index] = temp.get(index);

	    }

	}
	catch(Exception e){
	    teachers = new String[0];
	}

	return teachers;

    }

    public static double[][] getDataArray(String filePath){

  
	ArrayList<String> temp;
	//char[][] data;
	double[][] data;

	try{

	    File file = new File(filePath);
	    Scanner in = new Scanner(filePath);

	    temp = new ArrayList<String>();

	    //creates an arraylist of each line 
	    while(in.hasNextLine()){
		temp.add(in.nextLine());
	    }

	    data = new double[temp.size()][temp.get(0).length()/2];

	    for(int i = 0; i< temp.size(); i++){
		String str = temp.get(i);
		for(int j = 0; j < str.length() /2; j++){
		    data[i][j] = Double.parseDouble(""+str.charAt(j*2));
		}
	    }

	}catch(Exception e){
	    data = new double[0][0];
	}

	return data;
    }
    
    public static void main(String[]args){
	//MyFileReader mine = new MyFileReader();
	
	System.out.println(Arrays.deepToString(MyFileReader.getDataArray("1 1 1 1 \n2 2 2 2 \n")));
    }

}
