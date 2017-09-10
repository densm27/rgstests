package ru.aplana.autotests.steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import ru.aplana.autotests.pages.MainPage;

/**
 * Created by Maria on 10.09.2017.
 */
public class MainSteps  extends ScenarioSteps {

    MainPage mainPage;


    @Step("выбран пункт меню {0}")
    public void selectMenuItem(String menuItem){
        mainPage.selectMenuItem(menuItem);
    }

    @Step("выбран вид страхования {0}")
    public void selectMenuInsurance(String menuItem){
        mainPage.selectInsuranceItem(menuItem);
    }

}
