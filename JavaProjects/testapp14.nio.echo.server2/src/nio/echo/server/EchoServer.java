package nio.echo.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class EchoServer {

	int port;
	
	Selector selector;

	public EchoServer(int port) {
		// TODO Auto-generated constructor stub
		this.port = port;
	}

	ServerSocketChannel server;

	public void start() {
		// TODO Auto-generated method stub

		try {

			System.out.println("starting server on port " + port);
			server = ServerSocketChannel.open();
			
			server.configureBlocking(false); //non-blocking

			selector = Selector.open(); //agent for mutltiple channels

			// see what are the seletable option for current channel
			int ops = server.validOps();  // should be connect, receive etc

			server.register(selector, ops); // let selector handle the channel events ---> connect, receive etc

			server.bind(new InetSocketAddress("localhost", port));

			System.out.println("server ready");
			
			
			Set<SelectionKey> keys=null;
			//we don't wait to accept a  client or receive a message
			// we wait for the selector to inform me
			while (true) {
				try {
					
					int keyCount = selector.select(); // see how many items are ready for processing
					if (keyCount == 0) //nothing interestin yet in queue. so try to select again
						continue; // nothing yet. lets move on
					
					
					keys = selector.selectedKeys(); // list of ready events --> may be 3 clients waiting to be accept, 4 client message also pending

					for (SelectionKey key : keys) {   // lets see each message one by one

						if (key.isAcceptable()) // some client is waiting for connection
							doAccept();         // this is calling accept(), normally accept is blocking. but since client is already waiting its not blocking
						else if (key.isReadable()) // some message is waiting to be received from one of the many client channels
							doReceive(key);

					}
					//keys.clear(); // remove the processed keys

				} catch (DisconnectionException ex) {
					System.out.println("client quit");
				} catch (Exception ex) {
					System.out.println("error:" + ex.getMessage());
					
				}
				finally {
					keys.clear(); //once you have processed the keys you must remove it from the selector, otherwise you get same key again and again
				}
			}

		} catch (Exception ex) {
			System.out.println("Error setting up server :" + ex.getMessage());
			ex.printStackTrace();
		}
	}

	private void doReceive(SelectionKey key) throws Exception {
		// TODO Auto-generated method stub
		SocketChannel client = (SocketChannel) key.channel(); // which client has sent the message?
		
		
		String message = receive(client);
		System.out.println(client+":"+message);
		send(client, message);
		if (message.equals("bye")) {
		
			client.close();
			throw new DisconnectionException("disconnect the client");
		}
	}

	private void doAccept() throws Exception {
		// TODO Auto-generated method stub
		SocketChannel client = server.accept(); // not a blocking call. we already know we have a client
		int ops = client.validOps(); // find out what selector can do for this client channel --> eg receive
		client.configureBlocking(false);   //make it non-blocking
		System.out.println("client connected");
		client.register(selector, ops); // any message from this channel will be received by same selector
	}

	private void send(SocketChannel client, String str) throws IOException {
		// TODO Auto-generated method stub
		byte[] data = new String(str).getBytes();// convert string to byte []
		ByteBuffer buffer = ByteBuffer.wrap(data); // wrap byte array in a byte buffer
		client.write(buffer);
	}

	private String receive(SocketChannel client) throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate(256);
		buffer.clear();
		client.read(buffer);
		buffer.flip();
		String str = "";
		while (buffer.remaining() > 0)
			str += (char) buffer.get();
		return str;
	}

	public void stop() {
		// TODO Auto-generated method stub

	}

}
