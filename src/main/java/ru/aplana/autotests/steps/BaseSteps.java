package ru.aplana.autotests.steps;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.aplana.autotests.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Maria on 10.09.2017.
 */
public class BaseSteps {

    protected static String baseUrl;
    public static Properties properties = TestProperties.getInstance().getProperties();


    @Managed
    WebDriver driver;


    @Before
    public  void setUp() throws Exception {
        baseUrl = properties.getProperty("app.url");
        System.out.println(baseUrl);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl + "/");
    }

    @After
    public  void tearDown() throws Exception {
        driver.quit();
    }


}
