package DefaultMethodsWithMultipleInheritance;

public class Child implements GrandParent, Parent{
	
	public void higherStudies() {
		GrandParent.super.higherStudies();
		Parent.super.higherStudies();
	}	
	
//	public void higherStudies() {
//		System.out.println("I will join MCA");
//	}

	public static void main(String[] args) {
		Child child=new Child();
		child.higherStudies();

	}

}
