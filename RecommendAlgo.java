//package algorithm;

import java.util.List;
//THe main recommendation is done here.
public class RecommendAlgo
{
	public User usob;
	private int mUsers = 943;
	private int nItems = 1682;
	private int [][] inputData = new int[mUsers+1][nItems+1];
	private int [][] outputData = new int[mUsers+1][nItems+1];
	
	public RecommendAlgo(User a,int [][] input1,int [][] output1)
	{
		usob=a;
		inputData=input1;
		outputData=output1;
		
	}
	//This function checks if input [user][item] is zero or not
	public void generateR()
	{
		int prediction = 0;
		int i=1;
		while(i<=mUsers)
		{   int j=1;
			while(j<= nItems)
			{
				if(inputData[i][j] != 0)
				{
					outputData[i][j] = inputData[i][j];//If it is not zero then directly writes it on the output array.
				}
				else
				{
					getData(i,j,prediction); //if value is zero getData function is called.
					
				}
			j++;		
			}
			i++;
		}
	}
	//this function returns the predicted value for the particular [user][item] pair
	public void getData(int i,int j,int prediction)
	{
		Double value1= 0.0, value2 = 0.0;
		List<Integer> temp = usob.simUsMap.get(i); //The similarity mapping of that user is fetched into the list.
		for(int k : temp)
		{
			if(inputData[k][j]==0)
			{
				continue;
			}
			else //this part calculates the prediction value.
			{
				value1 += inputData[k][j] * usob.simUserCoMap.get(i).get(k);
				value2 += Math.abs(usob.simUserCoMap.get(i).get(k));
			}
		}
		getPred(prediction,value1,value2,i,j);
	}
	//this function validates the prediction value i.e it rounds off value to nearest integer.
	public void getPred(int pred,double value1,double value2,int i,int j)
	{
		pred = (int) ((value1/value2)+0.5); //rounding off value.
		if(pred < 1)
		{
			pred = 1;  //if prediction is between 0 and 1
		}
		else if(pred > 5)
		{
			pred = 5; // if prediction is greater than 5
		}
			outputData[i][j] = pred; //writing the prediction on output matrix.
	}
}
