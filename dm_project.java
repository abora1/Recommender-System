//package algorithm;

//import algorithm.DisplayFile;
public class dm_project {

	private int mUsers = 943;
	private int nItems = 1682;
	private int [][] inputData = new int[mUsers+1][nItems+1];
	private int [][] outputData = new int[mUsers+1][nItems+1];
	private FileInput f1;
	private FileOutput f2;
	private User userObj;
	private RecommendAlgo s;
	private DisplayFile w;
	public static void main(String[] args) {   //Main Method which takes the inputs and calls its constructor to generate input and output objects
		int [][]input1 = new int [944][1683];
		String inputFilename = "train_all.txt";
		String outputFilename = "output.txt";
		FileInput f1=new FileInput(inputFilename);
		FileOutput f2=new FileOutput(outputFilename);
		dm_project dp = new dm_project(f1,f2);
		dp.generateData(); 
		dp.recommendation();
		dp.displayData(input1);
		f1.closeStream();
		f2.closeStream();
	}
	//the object files of input,output and user are generated.
	public dm_project(FileInput fpi,FileOutput fpo) {
		f1 = fpi;
		f2=fpo;
		userObj = new User();
		
	}
//This method is used to take the input file and store it in an multidimensional array
	public void generateData() {
		String line = null;
		try {
			while((line = f1.readFromFile()) != null)
			{
				String[] inputtoken = line.split("\\s+");
				int a=Integer.parseInt(inputtoken[0]);
				int b=Integer.parseInt(inputtoken[1]);
				int c=Integer.parseInt(inputtoken[2]);
				inputData[a][b] = c;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	//user object is passed to RecommendAlgo.java to compute the similarities.
	public void recommendation() {
		userObj.findSimilarity(mUsers, inputData); //This function call finds the similarity on the User.java file
		s=new RecommendAlgo(userObj,inputData,outputData);//the similarity is used to find the Recommendation.
		s.generateR();
	}
	//This is used to send the file Writer object to the Fileoutput.java file.
	public void displayData(int [][] input1) 
	{
		w=new DisplayFile(f2,outputData);
		w.displayData(input1);
		
	}

}
