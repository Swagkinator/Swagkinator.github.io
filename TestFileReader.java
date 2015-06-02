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




    }












}