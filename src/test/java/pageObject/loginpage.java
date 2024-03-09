package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
    WebDriver driver;
    @FindBy(xpath = "//input[@placeholder=\"Username\"]")
    public WebElement user;
    @FindBy(name="mypassword")
    private WebElement password;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block\" and @type=\"submit\"]")
   public WebElement signupbutton;

     public loginpage(WebDriver d){
         driver= d;
        PageFactory.initElements(driver, this);
    }
    public void setUserName(String username){

         user.sendKeys(username);
    }
    public void setPassword(String pass){

        password.sendKeys(pass);
    }
    public void clickOnSignUp(){
        signupbutton.click();
    }







}
