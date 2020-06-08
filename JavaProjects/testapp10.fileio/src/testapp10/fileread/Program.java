package testapp10.fileread;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		copyFileByteByByte("./src/mydata.txt", "./src/mynewdata.txt");
		readFile("./src/mynewdata.txt");
		
		
		
		
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
