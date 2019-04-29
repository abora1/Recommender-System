//package algorithm;

import java.io.FileWriter;
import java.io.IOException;

// This class is used to write the output.txt file.
public class FileOutput {
	
	private String outputfile;
	public FileWriter writer;

	public FileOutput(String output_filename) {
		
		outputfile = output_filename;
		try {
			writer = new FileWriter(outputfile);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	
	//This function is used to write on file.
	public void writeToFile(String output)
	{
		try {
			writer.write(output+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// This method closes the File reader
	 
	public void closeStream() {
		
		try {
			if(writer != null)
				writer.close();
		} catch (Exception e) {
			System.err.println("Error occurred while closing file!");
		}
	}

}
