import java.util.*;
import java.io.*;

public class TestFileReader{


    public static void main(String[] args){

	String[] ans;
	ans =  MyFileReader.getQuestionArray("questions.txt");

	System.out.println(Arrays.toString(ans));


	String[] teacher;
	teacher = MyFileReader.getTeacherArray("teachers.txt");

	System.out.println(Arrays.toString(teacher));


	char[][] data;
	data= MyFileReader.getDataArray("data.txt");

	for(int i =0 ; i < data.length; i++){
	    String str = "";
	    for(int j = 0; j <data[0].length; j++){

		str += data[i][j];

	    }
	    System.out.println(str);
	}


    }












}