package nio.echo.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import javax.swing.plaf.synth.SynthSeparatorUI;

import test.io.Input;

public class EchoClient {

	
	
	
     
	
	public void start(String serverName, int port) {
		// TODO Auto-generated method stub
		
		try {
	
			System.out.println("connecting to "+ serverName+" on port "+port);
			
			//This channel helps me connect to the server
			SocketChannel server=SocketChannel.open();
			
			//try to connect to the given address
			//its a blocking call. Any way I can't do anything till client connects me
			server.connect(new InetSocketAddress(serverName, port));
			
			System.out.println("connected...");
		
			
			String msg="";
			
			while(!msg.equals("bye")) {
				
				msg= Input.readString("? ");
				
				send(server,msg);  //send the message to the server
				//this is a plain blocking call
				//because i have nothing to till client replies back
				String serverMessage=receive(server);
				
				System.out.println("server:"+serverMessage);
					
				
				
			}
			
			
			server.close(); //close the connection with the server
			
			
			
		}
		catch(Exception ex) {
			System.out.println("Error starting server:"+ex.getMessage());
		}
	}


	private void send(SocketChannel server, String str) throws IOException {
		// TODO Auto-generated method stub
		byte [] data= new String(str).getBytes();//convert string to byte []
		ByteBuffer buffer=ByteBuffer.wrap(data); //wrap byte array in a byte buffer
		server.write(buffer); //blocking
	}





	private String receive(SocketChannel server) throws IOException {
		ByteBuffer buffer=ByteBuffer.allocate(256);
	
		//buffer.clear();
		server.read(buffer); //read incomeing data
		buffer.flip();
		String str="";
		while(buffer.remaining()>0)
			str+=(char)buffer.get();
		return str;
	}
	
	
	
	
	
	
	
	
	
	public void stop() {
		// TODO Auto-generated method stub
		
	}

}
