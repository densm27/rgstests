import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DMSPage;
import pages.MainPage;
import pages.SendAppPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Maria on 07.09.2017.
 */

public class MyRefactoringTest extends BaseTest {


    @Test
    public void testInsurance() throws Exception {
        driver.get(baseUrl + "/");
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMenuItem("Страхование");
        mainPage.selectInsuranceItem("ДМС");

        new DMSPage(driver).waitSendAppClickable();

        SendAppPage sendAppPage = new SendAppPage(driver);
        String actualTitle = sendAppPage.title.getText();
        String expectedTitle = "Заявка на добровольное медицинское страхование";
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));


        sendAppPage.fillField("Фамилия", "Иванов");
        sendAppPage.fillField("Имя", "Иван");
        sendAppPage.fillField("Отчество", "Иванович");
        sendAppPage.fillField("Эл. почта", "222222ыыыыы");
        sendAppPage.fillField("Комментарии", "test");
        sendAppPage.fillField("Регион", "Москва");

        sendAppPage.sendButton.click();

        sendAppPage.checkFieldErrorMessage("Эл. почта", "Введите адрес электронной почты");

    }
}
