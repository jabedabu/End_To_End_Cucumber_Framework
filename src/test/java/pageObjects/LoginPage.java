package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="Email")
   @CacheLookup
    WebElement txtEmail;
    @CacheLookup
    @FindBy(id="Password")
    WebElement txtPassword;
    @CacheLookup
    @FindBy(xpath="//button[text()='Log in']")
    WebElement btnLogin;
    @CacheLookup
   @FindBy(xpath = "//a[text()='Logout']")
    WebElement lnkLogout;

  public void setUserName(String uname) {
      txtEmail.clear();
      txtEmail.sendKeys(uname);
  }
      public void setPassWord(String pwd){
          txtPassword.clear();
          txtPassword.sendKeys(pwd);

      }
 public void clickLogin(){
      btnLogin.click();
 }
    public void clickLogout(){
      lnkLogout.click();
    }

      }

