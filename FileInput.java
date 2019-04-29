//package algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//This class is used to read the input file.
public class FileInput {
	private String inputfile;
	private FileReader reader;
   private BufferedReader r1;
	

	public FileInput(String input_filename) {
		
		inputfile = input_filename;
		try {
			reader = new FileReader(inputfile);
			r1=new BufferedReader(reader);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	// * This method reads a line from the file and returns it.
	public String readFromFile() throws IOException
	{
		return r1.readLine();
	}
	
	
	
	/**
	 * This method closes the File reader
	 */
	public void closeStream() {
		
		try {
			if(reader !=null)
				reader.close();
		} catch (Exception e) {
			System.err.println("Error occurred while closing file!");
		} 
	}

}
