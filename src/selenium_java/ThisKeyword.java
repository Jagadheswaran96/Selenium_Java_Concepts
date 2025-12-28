package selenium_java;

public class ThisKeyword {
	
	//Super keyword will be used only in Inheritance
	
	ThisKeyword(int a){
		System.out.println("1");
	}
	ThisKeyword(int a, int b){
		this(1);
		System.out.println("2");
	}
	ThisKeyword(int a, int b, int c){
		this(1,2);
		System.out.println("3");
	}
	
	public static void main(String[] args) {
		ThisKeyword java=new ThisKeyword(1, 2, 3);
		System.out.println(java);
		
	}
}
