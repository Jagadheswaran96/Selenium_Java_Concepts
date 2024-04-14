package Interface;

@FunctionalInterface
public interface FuncationalInterface {
	//if interface contains only one abstract method then it is called as functional interface
	//two abstract methods are not allowed if interface declared with @FunctionalInterface
	//but object class's methods are allowed
	void funcationalInterface();
	//void funcationalInterface2();
	
	//object class's methods
	int hashCode();
	boolean equals(Object obj);
}
