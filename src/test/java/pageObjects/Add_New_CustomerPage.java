package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.WaitHelper;

public class Add_New_CustomerPage {

    public WebDriver driver;
WaitHelper waitHelper;
    public Add_New_CustomerPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper =new WaitHelper(driver);

    }
    By lnkCustomer_menu=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a/p");
    By lnkCustomer_menuItem=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p");
    By btnAddNew=By.xpath("//a[@class='btn btn-primary']");
    By txtEmail=By.id("Email");
    By txtPassword=By.id("Password");
    By txtFirstName=By.id("FirstName");
    By txtLastName=By.id("LastName");
    By rdMaleGender=By.id("Gender_Male");
    By rdFemaleGender=By.id("Gender_Female");
    By txtDob=By.xpath("//input[@id='DateOfBirth']");
    By txtCompanyName=By.id("Company");
    By txtCustomerRoles=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");
     By listitemAdministrators=By.xpath("//li[text()='Administrators']");
    By listitemForumModerators=By.xpath("//li[text()='Forum Moderators']");
    By listitemGuests=By.xpath("//li[text()='Guests']");
    By listitemRegistered=By.xpath("//li[text()='Registered']");
    By listitemVendors=By.xpath("//li[text()='Vendors']");
    By drpmgrOfVendor=By.xpath("//*[@id=\"VendorId\"]");
    By txtcomment=By.id("AdminComment");
    By btnSave=By.name("save");
    public String getPageTitle(){
        return driver.getTitle();
    }


    public void clickOnCustomerMenu(){
     driver.findElement(lnkCustomer_menu).click();
    }
    public void clickOnCustomer_menuItem(){
        driver.findElement(lnkCustomer_menuItem).click();
    }

    public void clickOnAddNew(){
        driver.findElement(btnAddNew).click();
    }
    public void setTxtEmail(String email) {
        driver.findElement(txtEmail).sendKeys(email);
    }
    public void setTxtPassword(String password) {
        driver.findElement(txtPassword).sendKeys(password);
    }
    public void setTxtFirstName(String firstName){
        driver.findElement(txtFirstName).sendKeys(firstName);

    }
    public void setTxtLastName(String lastName){
        driver.findElement(txtLastName).sendKeys(lastName);

    }

     public void setDateOfBirth(String dob){
        driver.findElement(txtDob).sendKeys(dob);
     }
 public void setCompanyName(String name){
        driver.findElement(txtCompanyName).sendKeys(name);
 }
       public void setGender(String gender){
        if(gender.equals("Male"))
        {
            driver.findElement(rdMaleGender).click();
        } else if (gender.equals("Female")) {
            driver.findElement(rdFemaleGender).click();
        }
        else {
            driver.findElement(rdMaleGender).click();
        }
       }
public void setTxtCustomerRoles(String guests)
{
    driver.findElement(txtCustomerRoles);
}

    public void setCustomerRoles(String role) throws InterruptedException {
        if(!role.equals("Registered"))
        {
            driver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[1]"));
        }
    driver.findElement(txtCustomerRoles).click();
        WebElement listitem;
        Thread.sleep(3000);
        if (role.equals("Guests"))
        {
            listitem= driver.findElement(listitemGuests);
        }
       else if (role.equals("Administrators"))

        {
            listitem= driver.findElement(listitemAdministrators);
        }

        else if (role.equals("Vendors"))

        {
            listitem= driver.findElement(listitemVendors);
        }
        else if (role.equals("Forum Moderators"))

        {
            listitem= driver.findElement(listitemForumModerators);
        }
      else {
            listitem= driver.findElement(listitemGuests);
        }
        //listitem.click();

       JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",listitem);

    }
public void setManagerOfVendor(String value){
        Select drp=new Select(driver.findElement(drpmgrOfVendor));
        drp.selectByVisibleText(value);

}
  public void setComment(String comment){
        driver.findElement(txtcomment).sendKeys(comment);
  }
    public void clickSave(){
        driver.findElement(btnSave).click();
    }
}
