package testapp.movieconsole01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Input {
	
	public static BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	
	public static String read(String prompt) {
		try {
		System.out.print(prompt);
		return reader.readLine();
		}
		catch(Exception ex) {
			return "";
		}
	}
	
	
	public static int readInt(String prompt) {
		return readInt(prompt,0);
	}
	public static int readInt(String prompt, int defaultValue) {
		try {
			return Integer.parseInt(read(prompt));
		}catch(Exception ex) {
			return defaultValue;
		}
	}

}
