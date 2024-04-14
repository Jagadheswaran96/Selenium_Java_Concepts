package practice;

public class LambdaExpressions {

	public int lambda(int a1, int a2) {
		return a1+a2;
	}
	//lambdo epression
	//above mehos can be written using lambda expression like below
	//(a1+a2)->{return a1+a2}
	public static void main(String[] args) {
		LambdaExpressions expressions=new LambdaExpressions();
		expressions.lambda(1, 2);

	}

}
