public class Swagkinator{    
    private Teacher[] Teachers;//Array of all teachers
    private String[] questions,teacherNames;
    private double[][] dataArray;//array containing all the answer data
    private Teacher current; //The mystery teacher currently being guessed

    public Swagkinator(){
	teacherNames = MyFileReader.getTeacherArray();
	questions = MyFileReader.getQuestionArray();
	dataArray = MyFileReader.getDataArray();
	Teachers =  new Teacher[teacherNames.length];
	current = new Teacher("mystery", questions.length);

	//initialize teacher array
	for(int x=0;x<teacherNames.length;x++){ 
	    Teachers[x] = new Teacher(teacherNames[x],questions.length);
	}
	
	//input data for each teacher
	for(int x=0;x<Teachers.length;x++){
	    for(int y=0;dataArray[x].length;y++){
		Teachers[x].changeAnswer(y,data[x][y]);
	    }
	}
	
    }

    private Teacher getBestGuess(){
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
}
