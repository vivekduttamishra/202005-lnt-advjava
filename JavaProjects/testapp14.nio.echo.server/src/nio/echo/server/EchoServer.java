package nio.echo.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class EchoServer {

	int port;
	public EchoServer(int port) {
		// TODO Auto-generated constructor stub
		this.port=port;
	}
	
	ServerSocketChannel server;
	
	public void start() {
		// TODO Auto-generated method stub
		
		try {
	
			System.out.println("starting server on port "+port);
			server=ServerSocketChannel.open();	 //starting the server
			server.bind(new InetSocketAddress("localhost", port));
			
			System.out.println("server ready");
			
			
			while(true) {
				try {
				System.out.println("Waiting for client");
				//accept is a blocking. I must wait endlessly till someone connects
				System.out.println("waiting for the next client...");
				SocketChannel client=server.accept(); //got a client
				System.out.println("client connected");
				
				String msg="";
				
				
				
				
				while(!msg.equals("bye")) {
					
					//receive is a blocking call. unless the client sends info nothing can be done
					msg= receive(client);
					
					System.out.println("client:"+msg);
					send(client,msg);				
					
					
				}
				}catch(Exception ex) {
					System.out.println("error :"+ex.getMessage());
				
				}
				
			}
			
			
		}
		catch(Exception ex) {
			System.out.println("Error starting server:"+ex.getMessage());
		}
	}


	private void send(SocketChannel client, String str) throws IOException {
		// TODO Auto-generated method stub
		byte [] data= new String(str).getBytes();//convert string to byte []
		ByteBuffer buffer=ByteBuffer.wrap(data); //wrap byte array in a byte buffer
		client.write(buffer);
	}









	private String receive(SocketChannel client) throws IOException {
		ByteBuffer buffer=ByteBuffer.allocate(256);
		buffer.clear();
		client.read(buffer);
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
