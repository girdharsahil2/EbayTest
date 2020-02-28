package Ebay_Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listners implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("******"+result.getName()+" - Test case started ******");
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("******"+result.getName()+" - Test case Passed ******");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("******"+result.getName()+" - Test case failed ******");
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("******"+result.getName()+" - Test case Skipped ******");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
