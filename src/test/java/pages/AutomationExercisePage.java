package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExercisePage {
    public AutomationExercisePage(){
        PageFactory.initElements(Driver.getdriver(),this);
    }

    @FindBy(xpath = "//a[text()=' Signup / Login']")
    public WebElement signUpLinki;

    @FindBy(xpath = "//h2[text()='Login to your account']")
    public WebElement loginAccountElementi;

    @FindBy(xpath = "(//input[@name='email'])[1]")
    public WebElement emailKutusu;

    @FindBy(xpath = "(//input[@name='password'])[1]")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButonu;

    @FindBy(xpath = "//*[text()=' Logged in as ']")
    public WebElement yaziGorunuyorMu;

    @FindBy(xpath="//*[text()=' Delete Account']")
    public WebElement hesapSilindi;

    @FindBy(xpath = "//b[text()='Account Deleted!']")
    public WebElement gorunuyorSilindi;

    @FindBy(xpath = "//a[text()=' Logout']")
    public WebElement logOut;




}
