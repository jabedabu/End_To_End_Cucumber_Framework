package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pageObjects.Add_New_CustomerPage;
import pageObjects.LoginPage;
import pageObjects.Search_Customer_By_Email;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Steps extends Base_Class {

@Before
    public void setup() throws IOException {

    logger= Logger.getLogger("End_To_End_BDD_Framework");
    PropertyConfigurator.configure("Log4j.properties");
        // reading properties.
        configProp =new Properties();
        FileInputStream configPropfile=new FileInputStream(".\\Property\\config.properties");
        configProp.load(configPropfile);



       String br=configProp.getProperty("browser");
       if(br.equals("chrome"))
       {
           System.setProperty("webdriver.chrome.driver",configProp.getProperty("chromePath"));
           driver = new ChromeDriver();
       }

      else if(br.equals("firefox"))
       {
           System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxPath"));
           driver = new FirefoxDriver();
       }
       else if(br.equals("chrome"))
       {
           System.setProperty("webdriver.ie.driver", configProp.getProperty("iexplorePath"));
           driver = new InternetExplorerDriver();
       }

       logger.info("******** Launcing Browser ********");
   }


    @Given("user Launch Chrome browser")
    public void user_launch_chrome_browser() {
       lp =new LoginPage(driver);
    }


    @When("User opens Url {string}")
    public void user_opens_url(String url) {
      logger.info("****-- open -** url");
       driver.get(url);
   driver.manage().window().maximize();
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
       logger.info("***-- Poviding loging details****-- ");
        lp.setUserName(email);
       lp.setPassWord(password);
    }

    @When("Click on Login")
    public void click_on_login() {
                       logger.info("***-- click login****-- ");
       lp.clickLogin();
    }

//    @Then("Page Title should be {string}")
//    public void page_title_should_be(String string) {
//        if (driver.getPageSource().contains("Login was unsuccessful"))
//        {
//            driver.close();
//            Assert.assertTrue(false);
//        }
//          else {
//            Assert.assertEquals(title,driver.getTitle());
//        }

  //  }

    @When("User click on Log out link")
    public void user_click_on_log_out_link() throws InterruptedException {
        logger.info("***-- user can click  logout button ****-- ");

        lp.clickLogout();
 Thread.sleep(3000);
    }

    @Then("close browser")
    public void close_browser() {
        logger.info("***-- close the browser ****-- ");

        driver.quit();
    }
      // Customer feature step definitions ------------------------->//

    @Then("User can view Dashboad")
    public void user_can_view_dashboad() {
        logger.info("***-- user can veiw the dashboad ***-- ");
        addCust=new Add_New_CustomerPage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());

    }
    @When("User click on customers Menu")
    public void user_click_on_customers_menu() throws InterruptedException {
        logger.info("***-- user can click on customermenu ****-- ");
        Thread.sleep(2000);
        addCust.clickOnCustomerMenu();
    }
    @When("click on customers Menu Item")
    public void click_on_customers_menu_item() throws InterruptedException {
        logger.info("***-- user can click on customermenu item ****-- ");
        Thread.sleep(2000);
      addCust.clickOnCustomer_menuItem();
    }
    @When("click on Add new button")
    public void click_on_add_new_button() throws InterruptedException {
        logger.info("***-- user can click on addnew button ****-- ");
        Thread.sleep(2000);
     addCust.clickOnAddNew();
    }
    @Then("User can view Add new customers page")
    public void user_can_view_add_new_customers_page() {
      logger.info("--****--- user can veiw customer page--****");
        Assert.assertEquals("Add a new customer / nopCommerce administration",addCust.getPageTitle());
    }
    @When("User enter customer info")
    public void user_enter_customer_info() throws InterruptedException {
     logger.info("****---- genrate random String email ***----");
        String email=randomstring()+"@gmail.com";
        logger.info("****---- insert email ***----");
        addCust.setTxtEmail(email);
        Thread.sleep(3000);
        logger.info("****---- insert password ***----");
      addCust.setTxtPassword("test123");
        logger.info("****---- insert firstname ***----");
      addCust.setTxtFirstName("javed");
        Thread.sleep(3000);
        logger.info("****---- insert lastname ***----");
      addCust.setTxtLastName("sifat");
        Thread.sleep(3000);
        logger.info("****---- insert male ***----");
      addCust.setGender("Male");
        logger.info("****---- insert datebirth ***----");
      addCust.setDateOfBirth("5/05/1994");
      addCust.setCompanyName("busyQA");
      Thread.sleep(3000);
      addCust.setTxtCustomerRoles("Guests");
      addCust.setComment("this is for testing........");
    }
    @When("click on save button")
    public void click_on_save_button() throws InterruptedException {
        addCust.clickSave();
        Thread.sleep(3000);
    }
    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String msg)
    {
    Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
            .contains("The new customer has been added successfully."));
    }

// ------ //    Search with email id ------>/////////////////

    @When("Enter customerEmail")
public void enter_customer_email() {
        logger.info("***---- inserert email ********____");
    searchCustomer =new Search_Customer_By_Email(driver);
        searchCustomer.setEmail("victoria_victoria@nopCommerce.com");


}
    @When("Click on search button")
    public void click_on_search_button() throws InterruptedException {
        logger.info("***----serch customer ********____");
        searchCustomer.clickSearch();
        Thread.sleep(3000);
}
    @Then("User should found Email in the Search table")
    public void user_should_found_email_in_the_search_table() {
        logger.info("***---- Verified propewrly by email  ********____");
       boolean status= searchCustomer.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
        Assert.assertEquals(true,status);
    }
  // ******--- Search customer with Name ******-------//////

    @When("Enter customer firstName")
  public void enter_customer_first_name() {
        logger.info("***---- first name providing  ********____");
    searchCustomer =new Search_Customer_By_Email(driver);
      searchCustomer.setFirstName("Victoria");
  }
    @When("Enter customer lastName")
    public void enter_customer_last_name() {
        logger.info("***---- provid lastname ********____");
    searchCustomer.setLastName("Terces");
    }
    @Then("User should be found the name in the Search table")
    public void user_should_be_found_the_name_in_the_search_table() {
      boolean status= searchCustomer.searchCustomerByName("Victoria Terces");
      Assert.assertEquals(true,status);
   logger.info("***---- Verified propewrly by name ********____");
    }
}