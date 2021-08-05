package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Maria on 06.05.2017.
 */
public class HealthInsurancePage extends BasePage{


    @FindBy(xpath = "//*[@class='content-document-header']")
    public WebElement title;

    @FindBy(xpath = "//a[contains(.,'Добровольное медицинское страхование (ДМС)')]")
    public WebElement dmsLink;

    public HealthInsurancePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
