import net.serenitybdd.jbehave.SerenityStepFactory;
import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.jbehave.core.annotations.*;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.openqa.selenium.WebDriver;
import ru.aplana.autotests.TestProperties;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.asList;

/**
 * Created by User on 14.06.2015.
 */
public class StoriesRunner extends SerenityStories {

    public static Properties properties = TestProperties.getInstance().getProperties();

    public StoriesRunner() {
        runSerenity().inASingleSession();
    }

    @Override
    protected String getRootPackage() {
        return "ru.aplana.autotests";
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return SerenityStepFactory.withStepsFromPackage("ru.aplana.autotests", configuration()).andClassLoader(getClassLoader());
    }

    @Override
    public List<String> storyPaths() {
        return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()).getFile(), asList("**/*.story".split("\\s*,\\s*")), null);
    }



    public static WebDriver getWebDriver() {
        return ThucydidesWebDriverSupport.getDriver();
    }

    @BeforeStories
    public void startScenario(){
        getWebDriver() .get(properties.getProperty("app.url"));
        getWebDriver() .manage().window().maximize();
        getWebDriver() .manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        getWebDriver() .manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @AfterStories
    public void afterMethod(){
        getWebDriver() .quit();
    }

}
