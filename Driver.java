import java.util.*;
import java.io.*;

public class Driver{

    private Swagkinator genie;


    public void out(String output){
	System.out.println(output);

    }

    public void pause(int ms){
	try {
	    Thread.sleep(ms);
	} catch (Exception e) {}
    }


    public static void main(String[] args){

	Driver test = new Driver();

    }


    public Driver(){
	genie = new Swagkinator();

	out("Welcome to Swagkinator!");
	out("");

	pause (100);

	startMenu();
	pause(500);

	play();
	guess();
    }



    public void startMenu(){

	Scanner in = new Scanner(System.in);

	out("Please select an option:");
	out("0: Start with Swagkinator");
	out("1: What is Swagkinator?");

	String input = "";
	while(!input.equals("0") && !input.equals("1")){
	    input = in.nextLine();
	    if(!input.equals("0") && !input.equals ("1")){
		out("Invalid Choice");
		out("");
	    }
	}

	if(input.equals("0")){}

	if(input.equals("1")){
	    helpScreen();
	}

    }



    public void play(){

	Scanner in = new Scanner(System.in);

	out("Think of any teacher at Stuyvesant High School!");

	pause(500);

	out("Okay, I'm ready");

	pause(800);

	int questionCounter = 1;

	while(genie.hasNextQuestion()){

	    out("");
	    out("=======================================Question " + questionCounter + ":=======================================");
	    out("");

	    out(genie.getNextQuestion());
	    out("0: Yes");
	    out("1: No");
	    out("2: I Don't Know");
	    out("3: Probably");
	    out("4: Probably not");

	    sendAnswer();

	    pause(500);

	    questionCounter++;

	}

    }

    public void guess(){

	String guess = genie.getBestGuess().toString();
	out("Is your teacher " + guess + "?");

	out("");
	out("0: Yes, You are a genius!");
	out("1: No, You are Incorrect!");

	inputGuess();
	addAQuestion();

	pause(100);

	out("Thank You!");

    }


    private void helpScreen(){

	Scanner in = new Scanner(System.in);

	out("====================================== Help! ========================================");
	out("Swagkinator was inspried by the Web Genie, Akinator. It guesses Stuyvesant Teachers");
	out("Just think of a Stuyvesant teacher and Swagkinator will guess who you are thinking of");
	out("Just answer the questions honestly. Please!");

	out("");

	out("Input Q to Exit");

	String input = "";
	while(!input.equals("Q")){
	    input = in.nextLine();
	    if(!input.equals("Q")){
		pause(100);
	    }
	}

	if(input.equals ("Q")){

	}

    }

    private void inputGuess(){

	Scanner in = new Scanner(System.in);

	String input = "";

	while(!input.equals("0") && !input.equals("1")){
	    input = in.nextLine();
	    if(!input.equals("0") && !input.equals("1")){
		out("Invalid Choice");
	    }
	}

	if(input.equals("0")){ //when the genie is correct the data is uploaded to the server and updated 
	    genie.uploadDataToServer();
	    //askToPlayAgain();
	}

	if(input.equals("1")){ //when the genie is incorrect it will ask for the user to add the teacher they were thinking of 
	    updateData();
	    //askToPlayAgain();

	}
    }

    private void updateData(){
	Scanner in = new Scanner(System.in);

	out("");
	out("Who were you thinking of");

	String teachername = in.nextLine();

	if(genie.isInDatabase(teachername)){
	    genie.uploadDataToServer(teachername);
	}else{
	    genie.addTeacher(teachername);
	}

	out("");
	//out("Thank You!");


    }
    private void addAQuestion(){
	Scanner in = new Scanner(System.in);

	out("");
	out("Please add a question about your teacher or any other teacher");

	String question = in.nextLine();

	genie.addQuestion(question);

    }

    /*

    private void askToPlayAgain(){

	Scanner in = new Scanner(System.in);

	out("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	out("Would you like to try again?");
	out("0: Yes");
	out("1: No");

	String input = "";

	while(!input.equals("0") && !input.equals("1")){
	    input = in.nextLine();

	    if(!input.equals("0") && !input.equals("1")){
		out("Exiting..");
		pause(500);
		input = "1";
	    }
	}

	if(input.equals("0")){
	    play();
	}

    }

    */
    private void sendAnswer(){

	Scanner in = new Scanner(System.in);
	String answer = "";

	while(!answer.equals("0") && !answer.equals("1") && !answer.equals("2") && !answer.equals("3") && !answer.equals("4")){
	    answer = in.nextLine();
	    if(!answer.equals("0") && !answer.equals("1") && !answer.equals("2") && !answer.equals("3") && !answer.equals("4")){
		out("Invalid Choice");
	    }
	}

	int choice = Integer.parseInt(answer);

	    if(choice == 0){
		genie.sendAnswerToNextQuestion("1.00");
	    }
	    if(choice == 1){
		genie.sendAnswerToNextQuestion("0.00");
	    }
	    if(choice == 2){
		genie.sendAnswerToNextQuestion("0.50");
	    }
	    if(choice == 3){
		genie.sendAnswerToNextQuestion("0.75");
	    }
	    if(choice == 4){
		genie.sendAnswerToNextQuestion("0.25");
	    }


    }




}