public class TestClient{
    public static void main(String[]args){
	Relay myRelay = new Relay();
	myRelay.writeToFile("FILENAME","If you are reading this,\n my code works");
	System.out.println(myRelay.retrieve("FILENAME"));
	//System.out.println(myRelay.retrieve("FILENAME"));
    }
}
