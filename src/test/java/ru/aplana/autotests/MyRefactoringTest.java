package ru.aplana.autotests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.aplana.autotests.steps.BaseSteps;
import ru.aplana.autotests.steps.DMSSteps;
import ru.aplana.autotests.steps.MainSteps;
import ru.aplana.autotests.steps.SendAppSteps;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Maria on 07.09.2017.
 */

@RunWith(SerenityRunner.class)
public class MyRefactoringTest extends BaseSteps{

    @Steps
    MainSteps mainPageSteps;

    @Steps
    DMSSteps dmsSteps;

    @Steps
    SendAppSteps sendAppSteps;

    HashMap<String, String> testData = new HashMap<>();

    @Title("Заявка на ДМС")
    @Test
    public void testInsurance() throws Exception {
        testData.put("Имя","Иван");
        testData.put("Фамилия","Иванов");
        testData.put("Отчество","Иванович");
        testData.put("Регион","Москва");
        testData.put("Телефон","9191111112");
        testData.put("Эл. почта","teststststs");
        testData.put("Дата контакта","10.10.2017");
        testData.put("Комментарии","Autotest");

        mainPageSteps.selectMenuItem("Страхование");
        mainPageSteps.selectMenuInsurance("ДМС");
        dmsSteps.checkPageTitle("Добровольное медицинское страхование");
        dmsSteps.goToSendAppPage();
        sendAppSteps.checkPageTitle("Заявка на добровольное медицинское страхование");

        sendAppSteps.fillFields(testData);

        testData.put("Телефон","+7 (919) 111-11-12");
        sendAppSteps.checkFillFields(testData);
        sendAppSteps.checkErrorMessageField("Эл. почта", "Введите адрес электронной почты");


    }
}
