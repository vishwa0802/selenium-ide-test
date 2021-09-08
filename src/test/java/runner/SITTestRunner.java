package runner;

import org.junit.runner.RunWith;



import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\vishwa.raicha\\eclipse-workspace\\SITJEPFramework\\src\\test\\java\\features\\SIT.feature"
		 ,glue={"stepdefiniton","SITStepDefinitons"}
 
 )

public class SITTestRunner {

}
