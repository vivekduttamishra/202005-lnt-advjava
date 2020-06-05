package in.conceptarchitect.testapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

	static BufferedReader reader;
	static {
		reader=new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static String readString(String prompt) {
		System.out.print(prompt);
		try {
			return reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
