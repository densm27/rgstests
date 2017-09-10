package ru.aplana.autotests.pages;

import org.openqa.selenium.WebElement;
import net.serenitybdd.core.annotations.findby.FindBy;
import ru.aplana.autotests.pages.BasePage;

/**
 * Created by Maria on 07.09.2017.
 */
public class DMSPage extends BasePage {

    @FindBy(xpath = "//*[@class='page-header']/*")
    public WebElement title;

    @FindBy(xpath = "//*[contains(text(),'Отправить заявку')][contains(@class,'btn')]")
    public WebElement sendAppBtn;




}
