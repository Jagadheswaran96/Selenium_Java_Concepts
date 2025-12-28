package testNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener{

	@Override
	public void onFinish(ITestContext result) {
		System.out.println("Current test execution is completed");
	}

	@Override
	public void onStart(ITestContext result) {
		System.out.println("Test case execution is started");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("The test case faild but within sucess percentage");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test case is failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case is skipped");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test case is going to start");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case is passed");
		
	}

}
