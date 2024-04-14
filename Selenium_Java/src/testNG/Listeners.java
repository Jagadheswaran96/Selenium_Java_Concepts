package testNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{

	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println("Test case execution is completed");
	}

	@Override
	public void onStart(ITestContext arg0) {
		System.out.println("Test case execution is started to execute");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println("The test case faild but within sucess percentage");
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println("Test case is failed");
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println("Test case is skipped");
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("Test case is going to start");
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("Test case is passed");
		
	}

}
