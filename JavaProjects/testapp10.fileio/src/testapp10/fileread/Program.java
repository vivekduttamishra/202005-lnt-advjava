package testapp10.fileread;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		//copyFileByteByByte("./src/mydata.txt", "./src/mynewdata.txt");
		copyLineByLine("./src/mydata.txt","./src/mylinedata.txt");
		readFile("./src/mynewdata.txt");
		
		
		
		
	}
	
	private static void copyLineByLine(String srcPath, String targetPath) {
		FileReader in=null;
		FileWriter out=null;
		BufferedReader reader=null;
		PrintWriter writer=null;
		
		try{
			
			in= new FileReader(srcPath);  //reads from a file using read
			reader=new BufferedReader(in);  //add line by line reading ability
			
			
			out=new FileWriter(targetPath); //write to a file using write method
			writer=new PrintWriter(out);    //adds print(), println(), printf() functions to any writer
			
			
			String line=reader.readLine(); //read one line of information
			
			while(line!=null) {   //when line becomes null you have reached the end
				
				writer.println(line);  //write one line of intfo
				line=reader.readLine(); //read the next line
			}
		
			

		}catch(IOException ex) {
			ex.printStackTrace();
		} finally {
			try{
				in.close(); 
				out.close();
				reader.close();
				writer.close();
			} catch(IOException ex) { /* do nothing*/}
		}
	}
	
	
	private static void copyFileByteByByte(String srcPath, String targetPath) {
		// TODO Auto-generated method stub
		
		FileInputStream in=null;
		FileOutputStream out=null;
		
		try{
			in= new FileInputStream(srcPath);
			out=new FileOutputStream(targetPath);
		
			while(true) {
				int value=in.read();
				if(value==-1)
					break;
				out.write(value);
			}

		}catch(IOException ex) {
			ex.printStackTrace();
		} finally {
			try{in.close(); out.close();} catch(IOException ex) { /* do nothing*/}
		}
				
	}

	private static void readFile(String filePath) {
		// TODO Auto-generated method stub
		
		FileInputStream in=null;
		
		try{
			in= new FileInputStream(filePath);
		
			String output="";
			long count=0;
			while(in.available()>0) {
				
				int value= in.read();
				count++;
				output+=(char)value;
			}
			
			System.out.println(output);
			System.out.println("--------------");
			System.out.println("Total size:"+count);

		}catch(IOException ex) {
			ex.printStackTrace();
		} finally {
			try{in.close();  } catch(IOException ex) { /* do nothing*/}
		}
				
	}

}
