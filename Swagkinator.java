import java.util.*;
public class Swagkinator{    
    private Teacher[] Teachers;//Array of all teachers
    private String[] questions,teacherNames;
    private double[][] dataArray;//array containing all the answer data
    private Teacher current; //The mystery teacher currently being guessed
    private Relay relay;
    private int currentQuestionNumber;

    public Swagkinator(){
	relay = new Relay();
	currentQuestionNumber = 0;
	teacherNames = MyFileReader.getTeacherArray(relay.retrieve("teachers.txt"));
	questions = MyFileReader.getQuestionArray(relay.retrieve("questions.txt"));
	dataArray = MyFileReader.getDataArray(relay.retrieve("data.txt"));
	Teachers =  new Teacher[teacherNames.length];
	current = new Teacher("mystery", questions.length);

	//initialize teacher array
	for(int x=0;x<teacherNames.length;x++){ 
	    Teachers[x] = new Teacher(teacherNames[x],questions.length);
	}
	
	//input data for each teacher
	for(int x=0;x<Teachers.length;x++){
	    for(int y=0;y<dataArray.length;y++){
		Teachers[x].changeAnswer(y,dataArray[x][y]);
	    }
	}

	System.out.println(Arrays.deepToString(dataArray));
    }

    public String getNextQuestion(){
	currentQuestionNumber++;
	return questions[currentQuestionNumber-1];
    }
    
    public boolean hasNextQuestion(){
	return currentQuestionNumber<questions.length;
    }

    public void sendAnswerToNextQuestion(String value){
	//System.out.println(currentQuestionNumber);
	//System.out.println(questions.length-1);
	
	//if(currentQuestionNumber<questions.length-1){
	current.changeAnswer(currentQuestionNumber-1,Double.parseDouble(value));
	    /*}else{
	    System.out.println(getBestGuess());
	    //do stuff
	    }*/
    }

    public Teacher getBestGuess(){
	Teacher currentBest = Teachers[0];
	double compareValue = Teachers[0].compareTo(current);
	for(int x=1;x<Teachers.length;x++){
	    double currentTeacherCompareValue = Teachers[x].compareTo(current);
	    if(currentTeacherCompareValue < compareValue){
		currentBest = Teachers[x];
		compareValue = currentTeacherCompareValue;
	    }
	}
	return currentBest;
    }    
    
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
	Swagkinator genie = new Swagkinator();
	while(genie.hasNextQuestion()){
	    System.out.println(genie.getNextQuestion());
	    genie.sendAnswerToNextQuestion(in.nextLine());
	}
	System.out.println(genie.getBestGuess());
	in.close();
    }
}
