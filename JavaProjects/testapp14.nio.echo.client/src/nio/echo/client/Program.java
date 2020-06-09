package nio.echo.client;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EchoClient client=new EchoClient();
		
		client.start("localhost",2825);
		
		
		//Input.readString("Hit Enter to Exit");
		
		//server.stop();
		
		
	}

}
