package practice;

public class ThisStatementInJava {
	
	ThisStatementInJava(int a){
		System.out.println("1");
	}
	ThisStatementInJava(int a, int b){
		this(1);
		System.out.println("2");
	}
	ThisStatementInJava(int a, int b, int c){
		this(1,2);
		System.out.println("3");
	}
	
	public static void main(String[] args) {
		ThisStatementInJava java=new ThisStatementInJava(1, 2, 3);
		System.out.println(java);
		
	}
}
