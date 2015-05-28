public class TestClient{
    public static void main(String[]args){
	Relay myRelay = new Relay();
	myRelay.writeToFile("FILENAME","If you are reading this, my code works");
    }
}
