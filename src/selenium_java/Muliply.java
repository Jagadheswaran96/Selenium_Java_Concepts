package selenium_java;

import java.util.Arrays;
import java.util.List;

public class Muliply {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numList = Arrays.asList(2,4,8,6,10);
		Boolean result = numList.stream().noneMatch(temp->temp*5%2==1);
		System.out.println(result);

	}

}
