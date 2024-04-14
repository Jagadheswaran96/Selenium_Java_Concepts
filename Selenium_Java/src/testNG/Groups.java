package testNG;

import org.testng.annotations.Test;

public class Groups {
	@Test(groups= {"Fan"})
	public void crompton() {
		System.out.println("Crompton fan");
	}
	@Test(groups= {"Fan"})
	public void orion() {
		System.out.println("Orion fan");
	}
	@Test(groups= {"Light"})
	public void philips() {
		System.out.println("Philips light");
	}
	@Test(groups= {"Light"})
	public void surya() {
		System.out.println("Surya light");
	}
	@Test(groups= {"Washing machine"})
	public void samsung() {
		System.out.println("Samsung washing machine");
	}
	@Test(groups= {"Washing machine"})
	public void bosch() {
		System.out.println("Bosch washing machine");
	}
	@Test(groups= {"Refridgerator"})
	public void godrej() {
		System.out.println("Godrej refridgerator");
	}
	@Test(groups= {"Refridgerator"})
	public void whirlpool() {
		System.out.println("Whirlpool refridgerator");
	}
}
