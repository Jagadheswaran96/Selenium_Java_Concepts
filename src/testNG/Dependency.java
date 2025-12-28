package testNG;

import org.testng.annotations.Test;

public class Dependency {
	@Test
	public void create() {
		System.out.println("create");
	}
	@Test
	public void edit() {
		System.out.println("edit");
	}
	@Test
	public void modify() {
		System.out.println("modify");
	}
	@Test(dependsOnMethods= {"edit"})
	public void delete() {
		System.out.println("delete");
	}
}
