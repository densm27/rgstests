package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Maria on 07.09.2017.
 */
public class MainPage extends BasePage{

    @FindBy(xpath = "//ol[contains(@class,'rgs-menu pull-left')]//a[@data-toggle='dropdown']")
    public WebElement menuButton;

    @FindBy(xpath = "//ol[contains(@class,'rgs-menu pull-left')]//form")
    WebElement menuItems;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectMenuItem(String itemName){
        menuItems.findElement(By.xpath(".//a[normalize-space(.)='"+itemName+"'][@class='hidden-xs']")).click();
    }

}
