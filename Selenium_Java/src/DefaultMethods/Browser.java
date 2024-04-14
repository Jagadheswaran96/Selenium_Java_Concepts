package DefaultMethods;

@FunctionalInterface
public interface Browser {
	
	//multiple default methods are allowed in functional interface
	//dafault methods can be implemented either unimplemented into the class 
	
	void browse();
	default void mediaPlayer() {
		System.out.println("Browser media player");
	}
}