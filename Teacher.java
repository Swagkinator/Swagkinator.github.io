import java.util.Math;

public class Teacher implements Comparable{
    private String name;
    private int[] averageAnswers;

    public Teacher(String name, int numQuestions){
	
	averageAnswers = new int[numQuestions];
	
	this.name = name;
    }
    
    public void changeAnswer(int index, int value){
	averageAnswers[index] = value;
    }
    
    public int[] getAnswerArray(){
	return averageAnswers;
    }
    
    //precondition of compareTo is that other and this have the same numQuesions
    public int compareTo(Teacher other){
	double total = 0;
	int[] otherAnswers = other.getAnswerArray();

	for(int x=0;x<averageAnswers.length;x++){
	    total += Math.abs(averageAnswers[x] - otherAnswers[x])
	}
	
	return total/otherAns
    }
    
}
