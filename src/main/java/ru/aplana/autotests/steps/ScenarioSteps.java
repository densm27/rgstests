package ru.aplana.autotests.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;


import java.util.Map;

/**
 * Created by Maria on 01.05.2017.
 */
public class ScenarioSteps {

    @Steps
    MainSteps mainPageSteps;

    @Steps
    DMSSteps dmsSteps;

    @Steps
    SendAppSteps sendAppSteps;

    @When("выбран пункт меню \"$menuName\"")
    public void selectMenuItem(String menuName){
        mainPageSteps.selectMenuItem(menuName);
    }

    @When("выбран вид страхования \"$menuName\"")
    public void selectMenuInsurance(String menuName){
        mainPageSteps.selectMenuInsurance(menuName);
    }

    @Then("заголовок страницы - ДМС равен \"$title\"")
    public void checkTitleDMSPage(String title){
        dmsSteps.checkPageTitle(title);
    }

    @When("выполнено нажати на кнопку Отправить заявку")
    public void clickBtnSendApp(){
        dmsSteps.goToSendAppPage();
    }

    @Then("заголовок страницы - Заявка на ДМС равен \"$title\"")
    public void checkTitleSendAppPage(String title){
        sendAppSteps.checkPageTitle(title);
    }


    @When("заполняются поля: $fields")
    public void fillForm(ExamplesTable fields){
        for (Map<String, String> row : fields.getRows()) {
            String field = row.get("field");
            String value = row.get("value");
            sendAppSteps.fillField(field, value);
        }
    }


    @Then("значения полей равны: $fields")
    public void checkFillForm(ExamplesTable fields){
        for (Map<String, String> row : fields.getRows()) {
            String field = row.get("field");
            String value = row.get("value");
            sendAppSteps.checkFillField(field, value);
        }
    }

    @Then("в поле $field присутствует сообщение об ошибке $errorMessage")
    public void checkErrorMessage(String field, String errorMessage){
        sendAppSteps.checkErrorMessageField(field, errorMessage);

    }


}
