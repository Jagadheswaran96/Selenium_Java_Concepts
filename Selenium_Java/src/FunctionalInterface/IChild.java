package FunctionalInterface;

@FunctionalInterface
public interface IChild extends IParent{
	void method1();
	int hashCode();
	boolean equals(Object obj);
	static void method2() {}
}
