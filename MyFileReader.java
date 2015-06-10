import java.util.*;
import java.io.*;

public class MyFileReader{ //needed to read data and questions

    private static final String questionFile = "questions.txt";
    private static final String teacherFile = "teachers.txt";
    private static final String dataFile = "data.txt";
    

    public static String[] getQuestionArray(){

	return getQuestionArray(questionFile);

    }

    public static String[] getTeacherArray(){

	return getTeacherArray(teacherFile);

    }

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

    /* public static double[][] getDataArray(String filePath){

  
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
       }*/
    public static double[][] getDataArray(String filePath) {
        ArrayList<double[]> builder = new ArrayList<double[]>();
        double[] tmp = new double[0];
        try {
            Scanner fileIn = new Scanner(filePath);
            while (fileIn.hasNextLine()) {
                boolean valid = true;
                String raw = fileIn.nextLine();
                if (raw.length() < 1) {
                    continue;
                }
                String[] unparsed = raw.split(" ");
                tmp = new double[unparsed.length];
                for (int i = 0; i < unparsed.length && valid; i++) {
                    tmp[i] = Double.parseDouble(unparsed[i]);
                }
                builder.add(tmp);
            }
            fileIn.close();
        } catch(Exception e) {
            return new double[0][0];
        }
        double[][] retVal = new double[builder.size()][0];
        for (int i = 0; i < builder.size(); i++) {
            retVal[i] = builder.get(i);
        }
        return retVal;
    }


    
    public static void main(String[]args){
	//MyFileReader mine = new MyFileReader();
	
	System.out.println(Arrays.deepToString(MyFileReader.getDataArray("1 1 1 1 \n2 2 2 2 \n")));
    }

}
