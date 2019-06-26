package com.bluzone.definitions;

import java.util.List;

import com.bluzone.apis.CreateUserRequest;
import com.bluzone.steps.TestSteps;

import cucumber.api.DataTable;

import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class SampleApiDefinition {
	@Steps
	TestSteps testSteps;

	@Given("^Run the sample PostTest$")
	
	public void runTheSampleTest() throws Throwable {
		
		// testSteps.runTestMethod();
		// testSteps.runSingleUser();
		//testSteps.runPostRequest();
		testSteps.runPostSwagger();
		

	}
}
