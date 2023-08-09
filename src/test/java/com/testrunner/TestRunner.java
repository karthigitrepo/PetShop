package com.testrunner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.baseclass.BaseClass;
import com.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin= "json:target\\output.json",features = "C:\\Users\\user\\eclipse-workspace\\API_AzhaguPetshop\\src\\test\\resources\\Features", 
					glue = "com.stepdefinition")

public class TestRunner extends BaseClass{
	@AfterClass
	public static void afterExecution() throws Exception, IOException {
		Reporting.generateJvmReport(getProjectPath() + getPropertyFileValue("jsonPath"));
	}
}
