package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.Environment;

public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(Driver.get(), this);

    }

    public void login(String userName, String passwod){


        username.sendKeys(userName);
        password.sendKeys(passwod);
        signIn_Button.click();


    }

    @FindBy(id = "inputEmail")
    public WebElement username;

    @FindBy(id = "inputPassword")
    public WebElement password;

    @FindBy(xpath = "//button[text()='Sign in']")
    public WebElement signIn_Button;

}
