//package algorithm;

// This class writes on the output file the array with the recommended values.
public class DisplayFile
{
	private FileOutput f2;
	private int mUsers = 943;
	private int nItems = 1682;
	private int [][] outputs = new int[mUsers+1][nItems+1];
	public DisplayFile(FileOutput fp,int [][] output1)
	{
		f2=fp;
		outputs=output1;
	}
	public void displayData(int [][] input1) {
		int g=1;
		while(g <= mUsers)
		{
			int h=1;
			while( h <= nItems)
			{
				String line = g + " " + h + " " + outputs[g][h];
				f2.writeToFile(line);
				
				h++;
			}
			g++;
		}
		System.out.println("The Output file named output.txt has been generated");
	}
}
