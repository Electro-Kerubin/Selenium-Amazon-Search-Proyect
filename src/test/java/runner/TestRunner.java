package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
                glue = {"steps"}, 
                plugin = {"pretty", "html:target/cucumber-reports"},
                tags = "@Login or @Navigation or @SearchFunctionality")
                // @Navigation or @SearchFunctionality or 
                // @CartFunctionality
                // @SearchFunctionality or 
public class TestRunner {

    @AfterClass
    public static void closeBrowserAfterTest() {
        BasePage.closeBrowser();
    }

}
