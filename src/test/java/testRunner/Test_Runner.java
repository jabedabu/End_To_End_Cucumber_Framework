package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (

               // features = ".\\Features\\",
                 features = ".\\Features\\NewCustomer_SerachByEmail.feature",
                // features = ".\\Features\\Add_New_Customers.feature",
           // features = {".\\Features\\Login.feature",".\\Features\\Add_New_Customers.feature"},

                glue = "stepDefinitions",
                dryRun =false,
                monochrome = true,
                plugin = {"pretty", "html:test-output"}
              // tags= "@sanity,@regression"
        )

public class Test_Runner {

}
