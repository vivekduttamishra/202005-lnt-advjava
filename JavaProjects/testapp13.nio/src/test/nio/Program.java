package test.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Program {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//testFileRead();
		
		nioCopy("src/indian-flag.jpg","src/indian-flag-2.jpg");
		//System.out.println("file written");
		
	}
	
	private static void nioCopy(String source, String destination) throws IOException {
		
		FileChannel src=new FileInputStream(source)    //Get a InputStream
								.getChannel();		   //And get a non-blocking channel
		
		FileChannel trgt=new FileOutputStream(destination).getChannel(); //Get non blocking channel from outstream 
		
		
		
		ByteBuffer buffer=ByteBuffer.allocate(8192); //8kb buffer
		
		int bytesRead=src.read(buffer); //read from channel, write to buffer
		while(bytesRead>0) {
			System.out.print("...");
			buffer.flip();   //flip the buffer so that we can read it to other channel
			trgt.write(buffer);  //write to other channel from the buffer
			buffer.clear();  //clear  and flip the buffer so that we can write by reading the channel
			bytesRead=src.read(buffer);  //read channel and write to bufefer
		}
		
		src.close();
		trgt.close();
		System.out.printf("\ncopied %s to %s\n",source,destination);
		
	}

	private static void testFileRead() throws FileNotFoundException, IOException {
		String fileName= "src/test/nio/numbers.txt";
		
		File file=new File(fileName);
		
		System.out.println("Length of file is "+file.length());
		
		
		
		FileChannel channel= new RandomAccessFile(fileName,"r")  //take a file that can be read "r"
							.getChannel();						 //and find its channel
		
		ByteBuffer buffer=ByteBuffer.allocate(512); //read 64 byte at a time.
		
		
		
		//buffer is by default writable (write mode). can't read from it
		// we can read a channle and write to buffer
		// it returns total byte read that will be equal to
		//        size of buffer if channel has data more than or equal to buffer size
		//        size of avaialble data if it is last read with remaining data
		//        -1 if we read after we reached the end
		// if we read a file of 650 bytes
		//       it will read 10 times 64 byte
		//       it will read 1 time 10 byte
		//       it will read 0 byte there after
		
		int bytesRead=channel.read(buffer); //read channel and write to buffer. returns byte read
		int readCount=0;
		
		String data="";
		
		while(bytesRead>0) {
			readCount++;
			
			System.out.print(bytesRead+"+");
			//remeber buffer is in write mode. must flip its mode to read from it
			buffer.flip(); //convert buffer to read mode
			
			while(buffer.remaining()>0)
				data+=(char) buffer.get();   //System.out.print((char)buffer.get()); //get bytes from the  buffer
			
			
			buffer.clear(); //clear current buffer content and flip it to write mode
			bytesRead=channel.read(buffer); //read next round
		}
		
		System.out.println(bytesRead);
		
		System.out.println("Read file in "+readCount+" times ");
		
		//System.out.println(data);
	}

}
