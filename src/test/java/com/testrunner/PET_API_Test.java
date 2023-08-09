package com.testrunner;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import com.baseclass.BaseClass;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojoclass.Request_POJOS;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PET_API_Test extends BaseClass {
	static ExtentTest logger;
	static ExtentReports report;

	
	@Test
	public void PET_API_Test_Method() {
		
		try {
			logger = report.startTest("POST METHOD");
			baseURI("store/order");
			Request_POJOS poj = new Request_POJOS(0, 0, 0, "2023-08-01T11:25:06.500Z", "placed", true);
			request = RestAssured.given();
			addBody(poj);
			ObjectMapper obj = new ObjectMapper();
			obj.writeValueAsString(poj);
			res = requestType("POST");
			Assert.assertEquals(200, res.getStatusCode());
			logger.log(LogStatus.PASS, "ResponseCode", String.valueOf(res.getStatusCode()));
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@AfterMethod
	public void after(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, result.getName(), result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, result.getName(), "Test Case Passed");
		}
	}

	@AfterClass
	public void afterClass() throws Throwable {
		report.endTest(logger);
		report.flush();

	}
	
	@BeforeClass
	public void beforeClass() throws Throwable {

		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReport\\Report.html");
		logger = report.startTest("PET_API_Test");

	}


}
