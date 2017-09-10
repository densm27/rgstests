package ru.aplana.autotests.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.aplana.autotests.pages.BasePage;

/**
 * Created by Maria on 10.09.2017.
 */
public class MainPage extends BasePage {

    @FindBy(xpath = "//ol[contains(@class,'rgs-menu pull-left')]")
    WebElement menuItems;

    @FindBy(xpath = "//div[contains(@class,'grid rgs-main-menu')]")
    WebElement menuInsurance;

    public void selectMenuItem(String itemName){
        menuItems.findElement(By.xpath(".//li[contains(@class,'current')]/*[contains(text(),'"+itemName+"')]")).click();
    }

    public void selectInsuranceItem(String itemName){
        menuInsurance.findElement(By.xpath(".//li[contains(@class,'line3-link')]//a[contains(text(),'"+itemName+"')]")).click();
    }
}
