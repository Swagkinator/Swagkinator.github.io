import java.util.*;
public class Swagkinator{    
    private Teacher[] Teachers;//Array of all teachers
    private String[] questions,teacherNames;
    private double[][] dataArray;//array containing all the answer data
    private Teacher current; //The mystery teacher currently being guessed
    private Relay relay;
    private int currentQuestionNumber,previousQuestionNumber,Qcounter;
    private boolean[] answered;
    private boolean hasHotfix;
    private Random random;
    public Swagkinator(){
	this(false);
    }
    
    public Swagkinator(boolean hotfix){
	
	//Initialize MAADDDDD variables
	relay = new Relay();
	hasHotfix = hotfix;
	currentQuestionNumber = 1;
	previousQuestionNumber = 1;
	if(hotfix){
	    currentQuestionNumber = 0;
	}
	teacherNames = MyFileReader.getTeacherArray(relay.retrieve("teachers.txt"));
	questions = MyFileReader.getQuestionArray(relay.retrieve("questions.txt"));
	dataArray = MyFileReader.getDataArray(relay.retrieve("data.txt"));
	Teachers =  new Teacher[teacherNames.length];
	current = new Teacher("mystery", questions.length);
	answered = new boolean[questions.length];
	random = new Random();
	//initialize teacher array
	for(int x=0;x<teacherNames.length;x++){ 
	    Teachers[x] = new Teacher(teacherNames[x],questions.length);
	}
	
	//input data for each teacher
	for(int x=0;x<Teachers.length;x++){
	    for(int y=0;y<dataArray[x].length;y++){
		Teachers[x].changeAnswer(y,dataArray[x][y]);
	    }
	}

    }

    private int[] answersToQuestions(int questionNumber){
	int[] ans =  new int[3];
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
		if(!foundOne || temp > ans){
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
	    if(row[x] < 0 && current.getAnswer(x)>=0){
		newRow[x] = current.getAnswer(x);
	    }else if(current.getAnswer(x)>=0){
		double newVal = row[x];
		newVal*= row[0];
		newVal += current.getAnswer(x);
		newVal /= row[0]+1;
		newRow[x] = newVal;
	    }
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
	    if(x.equals(correctTeacherName)){
		return i;
	    }
	    i++;
	}
	throw new NullPointerException();
    }

    public void uploadDataToServer(String teacherName){
	relay.writeToFile("data.txt",generateUpdatedValues(teacherName));
    }

    public void uploadDataToServer(){
	uploadDataToServer(""+getBestGuess());
    }
    
    public String getNextQuestion(){
	Qcounter++;
	previousQuestionNumber = currentQuestionNumber;
	if(hasHotfix){
	    return questions[currentQuestionNumber];
	}
	/*if(currentQuestionNumber < 2){
	    currentQuestionNumber++;
	    answered[currentQuestionNumber -1] = true;
	    return questions[currentQuestionNumber-1];
	    }else{*/
	if(random.nextInt(10) != 0){
	    int best = getBestQuestion();
	    currentQuestionNumber = best;
	    answered[best] = true;
	    return questions[best];
	}else{
	    int nRandom = random.nextInt(answered.length);
	    while(answered[nRandom]){
		nRandom = random.nextInt(answered.length);
	    }
	    currentQuestionNumber = nRandom;
	    answered[nRandom] = true;
	    return questions[nRandom];
	}
	//}
    }
    
    public boolean hasNextQuestion(){
	if(hasHotfix){
	    return currentQuestionNumber<questions.length-1;
	}
	return Qcounter<questions.length-1 && Qcounter<20;
    }

    public void sendAnswerToNextQuestion(String value){
	current.changeAnswer(currentQuestionNumber,Double.parseDouble(value));
	for(Teacher cTeacher: Teachers){
	    cTeacher.setCompareValue(current);
	}
	Arrays.sort(Teachers);
    }

    public Teacher getBestGuess(){
	return Teachers[0];
	/*Teacher currentBest = Teachers[0];
	double compareValue = Teachers[0].compareTo(current);
	for(int x=1;x<Teachers.length;x++){
	    double currentTeacherCompareValue = Teachers[x].compareTo(current);
	    if(currentTeacherCompareValue < compareValue){
		currentBest = Teachers[x];
		compareValue = currentTeacherCompareValue;
	    }
	}
	return currentBest;*/
    }    

    //public void

    public void addTeacher(String name){
	current.setName(name);
	Teacher newTeacher = current;
	
	relay.writeToFile("teachers.txt",relay.retrieve("teachers.txt")+newTeacher.getName());
	String newLine = "1.0 ";
	for(int i = 1;i<newTeacher.getAnswerArray().length;i++){
	    double x = newTeacher.getAnswerArray()[i];
	    newLine += x+" ";
	}
	relay.writeToFile("data.txt",relay.retrieve("data.txt")+newLine);
    }

    private void updateArray(String correctTeacherName){
	int index = findTeacher(correctTeacherName);
	double[] row = dataArray[index];
	double[] newRow = new double[row.length];
	newRow[0] = row[0]+1;

	for(int x=1;x<row.length;x++){
	    if(current.getAnswer(x)>=0){
		double newVal = row[x];
		newVal*= row[0];
		newVal += current.getAnswer(x);
		newVal /= row[0]+1;
		newRow[x] = newVal;
	    }
	}
	dataArray[index] = newRow;
    }

    public void addQuestion(String newQuestion){
	relay.writeToFile("questions.txt",relay.retrieve("questions.txt")+newQuestion);
	double[][] holder = new double[dataArray.length][dataArray[0].length+1];
	for(int x=0;x<dataArray.length;x++){
	    for(int y=0;y<dataArray[x].length;y++){
		holder[x][y] = dataArray[x][y];
	    }
	    holder[x][holder[x].length-1] = -1.0;
	}

	String ans = "";
	for(double[] x: holder){
	    for(double y: x){
		ans+= y+" ";
	    }
	    ans+="\n";
	}
	relay.writeToFile("data.txt",ans);
    }
    
    public boolean isInDatabase(String teacherName){
	boolean ans = false;
	for(Teacher x : Teachers){
	    if(x.getName().equals(teacherName)) ans = true;
	}
	return ans;
    }

    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
	Swagkinator genie = new Swagkinator();
	System.out.println(genie.isInDatabase("Majewski"));
	System.out.println(genie.isInDatabase("Jumash"));
	System.out.println(genie.isInDatabase("Zamansky"));
	System.out.println(genie.isInDatabase("Someone"));

	while(genie.hasNextQuestion()){
	    System.out.println(genie.getNextQuestion());
	    genie.sendAnswerToNextQuestion(in.nextLine());
	}
	System.out.println(genie.getBestGuess());
	//genie.uploadDataToServer();
	/*System.out.println("Who was the teacher");
	genie.addTeacher(in.nextLine());

	System.out.println("gimme a new question");
	genie.addQuestion(in.nextLine());*/
	//System.out.println(genie.generateUpdatedValues("Konstantinovich"));
	in.close();
    }
}
