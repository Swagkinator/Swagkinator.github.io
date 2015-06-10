import java.lang.Math;

public class Teacher{// implements Comparable{
    private String name;
    private double[] averageAnswers;

    public Teacher(String name, int numQuestions){
	
	averageAnswers = new double[numQuestions];
	
	this.name = name;
    }

    public String getName(){
	return name;
    }
    
    public void changeAnswer(int index, double value){
	averageAnswers[index] = value;
    }

    public double getAnswer(int index){
	return averageAnswers[index];
    }
    
    public double[] getAnswerArray(){
	return averageAnswers;
    }
    
    //precondition of compareTo is that other and this have the same numQuesions
    //Should later be otpomized for user age and whatnot
    public double compareTo(Teacher other){
	double total = 0;
	double[] otherAnswers = other.getAnswerArray();

	for(int x=1;x<averageAnswers.length;x++){
	    total += Math.abs(averageAnswers[x] - otherAnswers[x]);
	}
	
	return total/otherAnswers.length;
    }
    
    public String toString(){
	String ans = name;
	for(double x: averageAnswers){
	    ans+="\n"+x;
	}
	return ans;
    }
    
}
