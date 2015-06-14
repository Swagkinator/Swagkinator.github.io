import java.util.*;
public class Swagkinator{    
    private Teacher[] Teachers;//Array of all teachers
    private String[] questions,teacherNames;
    private double[][] dataArray;//array containing all the answer data
    private Teacher current; //The mystery teacher currently being guessed
    private Relay relay;
    private int currentQuestionNumber,previousQuestionNumber;
    private boolean[] answered;


    private boolean hasHotfix;
    public Swagkinator(){
	this(false);
    }
    
    public Swagkinator(boolean hotfix){
	relay = new Relay();
	hasHotfix = hotfix;
	currentQuestionNumber = 1;
	if(hotfix){
	    currentQuestionNumber = 0;
	}
	teacherNames = MyFileReader.getTeacherArray(relay.retrieve("teachers.txt"));
	questions = MyFileReader.getQuestionArray(relay.retrieve("questions.txt"));
	dataArray = MyFileReader.getDataArray(relay.retrieve("data.txt"));
	Teachers =  new Teacher[teacherNames.length];
	current = new Teacher("mystery", questions.length);
	answered = new boolean[questions.length];
	//System.out.println(Arrays.toString(answered));
	//initialize teacher array
	for(int x=0;x<teacherNames.length;x++){ 
	    Teachers[x] = new Teacher(teacherNames[x],questions.length);
	}
	
	//input data for each teacher
	//System.out.println(Arrays.deepToString(dataArray));
	for(int x=0;x<Teachers.length;x++){
	    for(int y=0;y<dataArray[x].length;y++){
		Teachers[x].changeAnswer(y,dataArray[x][y]);
	    }
	    //System.out.println(Teachers[x]);
	}

	//System.out.println(Arrays.deepToString(dataArray));
    }

    private int[] answersToQuestions(int questionNumber){
	int[] ans =  new int[3];
	//int yes = 0;
	//int no = 0;
	for(int x=0;x<Teachers.length/2;x++){
	    if(Teachers[x].getAnswer(questionNumber) >= 0){
		if(Teachers[x].getAnswer(questionNumber) > 0.625){
		    ans[0]++;
		}else if(Teachers[x].getAnswer(questionNumber) < 37.5){
		    ans[1]++;
		}else{
		    ans[2]++;
		}
	    }
	}
	return ans;
    }

    private int getIndexOfQuestionGoodness(int[] dist){
	//System.out.println(Arrays.toString(dist));

	if(dist[0] < dist[1]){
	    return dist[0];
	}else{
	    return dist[1];
	}
    }

    private int getBestQuestion(){
	int ansIndex = 1;
	int ans = getIndexOfQuestionGoodness(answersToQuestions(1));
	boolean foundOne = false;
	for( int x = 1;x<questions.length;x++ ){
	    if(!answered[x]){
		int temp = getIndexOfQuestionGoodness(answersToQuestions(x));
		//System.out.println(Arrays.toString(answered));
		//System.out.println(temp);
		
		if(!foundOne || temp > ans){
		    //System.out.println("oh god");
		    ans = temp;
		    ansIndex = x;
		    foundOne = true;
		}
	    }
	}
	return ansIndex;
    }

    public String generateUpdatedValues(String correctTeacherName){
	int index = findTeacher(correctTeacherName);
	double[] row = dataArray[index];
	double[] newRow = new double[row.length];
	newRow[0] = row[0]+1;

	for(int x=1;x<row.length;x++){
	    //System.out.println(x);
	    double newVal = row[x];
	    newVal*= row[0];
	    newVal += current.getAnswer(x);
	    newVal /= row[0]+1;
	    newRow[x] = newVal;
	}
	dataArray[index] = newRow;
	String ans= "";
	
	for(double[] x: dataArray){
	    for(double y: x){
		ans+= y+" ";
	    }
	    ans+="\n";
	}
	return ans.substring(0,ans.length()-1);
    }
    
    private int findTeacher(String correctTeacherName){
	int i=0;
	for(String x: teacherNames){
	    //System.out.println(x);
	    if(x.equals(correctTeacherName)){
		return i;
	    }
	    i++;
	}
	throw new NullPointerException();
    }

    public void uploadDataToServer(){
	relay.writeToFile("data.txt",generateUpdatedValues(""+getBestGuess()));
    }
    
    public String getNextQuestion(){
	previousQuestionNumber = currentQuestionNumber;
	if(hasHotfix){
	    return questions[currentQuestionNumber];
	}
	if(currentQuestionNumber < 2){
	    currentQuestionNumber++;
	    answered[currentQuestionNumber -1] = true;
	    return questions[currentQuestionNumber-1];
	}else{
	    //System.out.println("THESTRUGGLE");
	    int best = getBestQuestion();
	    currentQuestionNumber = best;
	    answered[best] = true;
	    return questions[best];
	}
    }
    
    public boolean hasNextQuestion(){
	if(hasHotfix){
	    return currentQuestionNumber<questions.length-1;
	}
	return currentQuestionNumber<questions.length;
    }

    public void sendAnswerToNextQuestion(String value){
	//System.out.println(currentQuestionNumber);
	//System.out.println(questions.length-1);
	
	//if(currentQuestionNumber<questions.length-1){
	
	//System.out.println(value);
	current.changeAnswer(previousQuestionNumber,Double.parseDouble(value));
	for(Teacher cTeacher: Teachers){
	    cTeacher.setCompareValue(current);
	}
	Arrays.sort(Teachers);
	/*}else{
	  System.out.println(getBestGuess());
	  //do stuff
	  }*/
    }

    public Teacher getBestGuess(){
	//System.out.println(current);
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
	//genie.uploadDataToServer();
	//System.out.println(genie.generateUpdatedValues("Konstantinovich"));
	in.close();
    }
}
