package selenium_java;
import java.util.ArrayList;
import java.util.List;

public class Mars {

	public static void main(String[] args) {

		int i1=12;
		int i2=4;
		int i3[]= {1,5,7,9};
		System.out.print(cal(i1,i2,i3));
	}

	private static int cal(int i1, int i2, int[] i3) {
		int sum=i1;
		int max=Integer.MIN_VALUE;
		List<Integer> l=new ArrayList<>();
		for(int i=0;i<i3.length;i++)

		{
			l.add(i3[i]);
		}
		for(int i=1;i<=i1;i++)
		{
			sum=sum-i;
			int count=0;
			if(!l.contains(i))
			{
				for(int j=i+1;j<=i1;j++)
				{
					if(!l.contains(j) && (sum-j)>=0)
					{
						sum=sum-j;
						count++;
					}
				}
				max=Math.max(count, max);
			}
		}
		return max+1;
	}

}