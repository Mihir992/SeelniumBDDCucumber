package com.cucumber.runners;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

 @CucumberOptions(
		 //plugin = {"pretty","html:target/site/cucumber-pretty","json:target/cucumber.json"},
		 //plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		 //snippets = CAMELCASE,
		 //dryRun = true,
		 features = "src/test/resources/feature",
		 glue = {"stepDefinitions"},
		 tags = {"@TestngTest"})
 public class TestNGRunnerTest{
	 private TestNGCucumberRunner testNGCucumberRunner;
	 
	 @BeforeClass(alwaysRun = true)
	 public void setUpClass() {
		 testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	 }
	 
	 @Test(dataProvider = "features")
	 public void feature(PickleEventWrapper eventwrapper,CucumberFeatureWrapper cumcumberFeature) throws Throwable {
		 //testNGCucumberRunner.runCucumber(cumcumberFeature.getCucumberFeature());
		 testNGCucumberRunner.runScenario(eventwrapper.getPickleEvent());
	 }
	 
	 @DataProvider
	 public Object[][] features(){
		 return testNGCucumberRunner.provideScenarios();
	 }
	 
	 @AfterClass(alwaysRun = true)
	 public void tearDownClass() {
		 testNGCucumberRunner.finish();
	 }
 }
