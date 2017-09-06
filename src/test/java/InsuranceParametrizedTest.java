import java.util.Arrays;
import java.util.Collection;
import org.junit.*;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


@RunWith(Parameterized.class)
public class InsuranceParametrizedTest extends BaseTest{


  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
            { "Иванов", "Иван" }, { "Петров", "Петр" }
    });
  }

  @Parameterized.Parameter // first data value (0) is default
  public /* NOT private */ String lastName;

  @Parameterized.Parameter(1)
  public /* NOT private */ String firstName;



@Ignore
  @Test
  public void testInsurance() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Страхование")).click();
    Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
    wait.until(ExpectedConditions.elementToBeClickable(
            driver.findElement(By.linkText("ДМС"))));

    driver.findElement(By.linkText("ДМС")).click();


    wait.until(ExpectedConditions.visibilityOf(
            driver.findElement(By.xpath("//*[contains(text(),'Отправить заявку')][contains(@class,'btn')]"))));

    driver.findElement(By.xpath("//*[contains(text(),'Отправить заявку')][contains(@class,'btn')]")).click();

    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[@class='modal-title']"))));

    assertEquals("Заявка на добровольное медицинское страхование",
            driver.findElement(By.xpath("//h4[@class='modal-title']")).getText());

    fillField(By.name("LastName"), lastName);
    fillField(By.name("FirstName"), firstName);
    fillField(By.name("MiddleName"), "Иванович");

    new Select(driver.findElement(By.name("Region"))).selectByVisibleText("Москва");

    fillField(By.name("Email"), "йцукенqwery");
    fillField(By.name("Comment"), "test");

    driver.findElement(By.cssSelector("input.checkbox")).click();
    driver.findElement(By.id("button-m")).click();

    checkFillField(lastName, By.name("LastName"));
    checkFillField("Иванович", By.name("MiddleName"));
    checkFillField(firstName, By.name("FirstName"));
    checkFillField("йцукенqwery", By.name("Email"));
    checkFillField("test", By.name("Comment"));

    assertEquals("Москва",
            new Select(driver.findElement(By.name("Region"))).getAllSelectedOptions().get(0).getText());

    assertEquals("Введите адрес электронной почты",
            driver.findElement(By.xpath("//*[text()='Эл. почта']/..//span[@class='validation-error-text']")).getText());
  }




}
