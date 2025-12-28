package selenium_java;

public class Array {

	public static void main(String[] args) {
		
		String[] array=new String[5];
		array[0]="string1";
		array[1]="string2";
		array[2]="string1";
		System.out.println(array[1]);
		System.out.println(array.length);
		
		int[] sel=new int[2];
		sel[0]=10;
		sel[1]=20;
		System.out.println(sel[0] + sel[1]);
		int number = 123;
		System.out.println(String.valueOf(number).length());
		System.out.println(array[6]);

	}

}
