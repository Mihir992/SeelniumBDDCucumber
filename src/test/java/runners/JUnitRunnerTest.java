package com.cucumber.runners;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
   //path of feature file
   features = "C:\\Users\\admin\\eclipseworkspace\\CucumberFramework\\src\\test\\resources\\feature\\Login.feature",
   //path of step definition file
   glue = "com.cucumber.stepDefinitions/LoginStepDefs"
   )
public class JUnitRunnerTest {
}