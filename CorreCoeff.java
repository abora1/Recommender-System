//package algorithm;
//This class calculates the correlation coefficient
public class CorreCoeff
{
	public double getCorrelationCoeff(int [] user1, int [] user2) {
		double coeff = 0.0;
		int i = 1, sum1 = 0, sum2 = 0, sum3 = 0;
		while(i <  user1.length)
	    {
	    	sum1 += ((user1[i] - 3) * (user2[i] - 3)); // These three lines calculate the coefficient using the cosine similarity.
	    	sum2 += power(user1[i] - 3, 2);   // The dot product of two values divided by multiplication of their square root.
	    	sum3 += power(user2[i] - 3, 2);
	    i++;
	    }
		double sum4=square_root(sum2);
		double s=square_root(sum3);
	    coeff = (sum1 / (sum4*s));   //coeff value is obtained here.
	    return coeff;
	}
	//power calculation
	public int power(int a,int b)
	{
		int p=0;
		p=(int) Math.pow(a,b);
	return p;
	}
	//square root calculation
    public double square_root(int num) {
        double x1 = (num * 1.0) / 2;
        double x2= (x1 + (num / x1)) / 2;
        while(Math.abs(x1 - x2) >= 0.0000001) {
          x1 = x2;
          x2 = (x1 + (num / x1)) / 2;
        }
        return x2;
      }
}
