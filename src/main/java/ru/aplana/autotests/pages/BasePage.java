package ru.aplana.autotests.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maria on 07.09.2017.
 */
public class BasePage extends PageObject{



    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

  }
