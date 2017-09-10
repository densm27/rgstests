package ru.aplana.autotests.steps;

import net.thucydides.core.annotations.Step;
import ru.aplana.autotests.pages.DMSPage;

import static org.junit.Assert.assertTrue;

/**
 * Created by Maria on 10.09.2017.
 */
public class DMSSteps {

    DMSPage dmsPage;

    @Step("выполнено нажатие на Отправить заявку")
    public void goToSendAppPage(){
        dmsPage.sendAppBtn.click();
    }


    @Step("заголовок страницы - ДМС равен {0}")
    public void checkPageTitle(String expectedTitle){
        String actualTitle = dmsPage.title.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }


}
