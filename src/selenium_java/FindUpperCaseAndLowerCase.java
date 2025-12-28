package selenium_java;

public class FindUpperCaseAndLowerCase {

	/*
	 * public static void main(String[] args) { String name = "Automation Testing";
	 * for(int i=0 ; i<name.length(); i++){
	 * if(Character.isUpperCase(name.charAt(i))){
	 * System.out.println("UpperCases are:" + name.charAt(i)); }else
	 * if(Character.isLowerCase(name.charAt(i))){
	 * System.out.println("LowerCases are:" + name.charAt(i)); }
	 * 
	 * } }
	 */
	 public static void main (String[]args)
	  {
	    String name = "Jagadhes";
	    for (int i=0; i<name.length(); i++)
	      {
		if (Character.isUpperCase(name.charAt(i)))
		  {
		    System.out.println ("Hello World");
		  }
	      }
	  }
}
