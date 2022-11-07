package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {
    public FacebookPage()//önce bir constructor oluşturuyoruz
    {
        PageFactory.initElements(Driver.getdriver(),this);
    }
@FindBy(xpath = "//button[@data-cookiebanner='accept_button']")
    public WebElement cerezleriKabulet;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailKutusu;

    @FindBy(xpath = "//input[@id='pass']")
    public WebElement sifreKutusu;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement girisButonu;

    @FindBy(xpath = "//div[@class='_9ay7']")
    public WebElement girilemediYaziElementi;


}
