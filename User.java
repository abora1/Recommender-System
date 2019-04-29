//package algorithm;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class User {
	public Map<Integer, TreeMap<Integer, Double>> simUserCoMap;
	private CorreCoeff coef;
	public TreeMap<Integer, Double> simUserCoef;
	public Map<Integer, List<Integer>> simUsMap;
	public List<Integer> similarUsers;
	private double corrCoeff = 0.0;
// Here TreeMap and List structure are used to find similarities between users and store them.
	public User() {
		simUsMap = new TreeMap<Integer, List<Integer>>();
		simUserCoMap = new TreeMap<Integer, TreeMap<Integer, Double>>();
		coef=new CorreCoeff();
	}
	
	public void findSimilarity(int mUsers, int[][] inputData) {
		int i = 0, j =0;
		for(i = 1; i <= mUsers; i++)
		{
			simUserCoef = new TreeMap<Integer, Double>();
			similarUsers = new ArrayList<Integer>();
			for(j = 1; j<= mUsers; j++)
			{
				if(i!=j)
					
				{
					corrCoeff = coef.getCorrelationCoeff(inputData[i], inputData[j]);// This function calls CorreCoeff.java file which calculates the correlation coefficient.
					if(corrCoeff > 0.3) //IT only stores the coefficient if it is greater than 0.3
					{
						similarUsers.add(j);//this adds the j user to i user's similar user list
						simUserCoef.put(j, corrCoeff); //it saves the coefficient of j user.
					}
				}
				else
				{
					continue;
				}
			}
			simUsMap.put(i, similarUsers); //Map's the i user with similar users list
			simUserCoMap.put(i, simUserCoef);//map's i user with similar user's coefficient.
		}
	}

}
