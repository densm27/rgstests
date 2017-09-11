
import org.testng.annotations.Test;
import pages.DMSPage;
import pages.MainPage;
import pages.SendAppPage;

import static org.testng.AssertJUnit.assertTrue;


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
