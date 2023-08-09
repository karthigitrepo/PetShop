package com.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.baseclass.BaseClass;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;



public class Reporting extends BaseClass {
	public static void generateJvmReport(String jsonFile) throws FileNotFoundException, IOException {
		File file = new File(getProjectPath() + getPropertyFileValue("jvmpath"));
		Configuration config = new Configuration(file, "Api_AzhaguPetshop");
	

		java.util.List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);
		ReportBuilder builder = new ReportBuilder(jsonFiles, config);
		builder.generateReports();

	}

}
