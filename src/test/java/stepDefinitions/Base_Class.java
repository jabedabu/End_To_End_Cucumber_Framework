package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObjects.Add_New_CustomerPage;
import pageObjects.LoginPage;
import pageObjects.Search_Customer_By_Email;

import java.util.Properties;

public class Base_Class {

    public WebDriver driver;
    public LoginPage lp;
    public Add_New_CustomerPage addCust;
    public Search_Customer_By_Email searchCustomer;
    public static Logger logger;
  public Properties configProp;
     public static String randomstring(){   // created random unique email.
         String generatedString1= RandomStringUtils.randomAlphabetic(5);
         return(generatedString1);

     }









}
