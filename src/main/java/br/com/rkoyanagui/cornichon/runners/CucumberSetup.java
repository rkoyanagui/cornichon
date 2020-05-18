package br.com.rkoyanagui.cornichon.runners;

import br.com.rkoyanagui.cornichon.screen.interactions.ScreenshotTaker;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;
import br.com.rkoyanagui.cornichon.spring.BasicConfig;
import br.com.rkoyanagui.cornichon.spring.WebDriverConfig;
import br.com.rkoyanagui.cornichon.utils.Context;
import br.com.rkoyanagui.cornichon.utils.Key;
import br.com.rkoyanagui.cornichon.utils.Reporter;
import io.cucumber.java8.Pt;
import io.restassured.response.ValidatableResponse;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {
    BasicConfig.class,
    WebDriverConfig.class
})
public final class CucumberSetup implements Pt {

  @Autowired
  private Context context;
  @Autowired
  private Reporter reporter;
  @Autowired
  private ScreenshotTaker screenshotTaker;
  private static final String MEDIA_TYPE = "image/png";

  public CucumberSetup() {

    Before(() -> {
    });

    AfterStep(scenario -> {

      reporter.getAll()
          .forEach((key, value) -> scenario.write(String.format("{\"%s\": %s}", key, value)));
      reporter.clear();

      screenshotTaker.getAll()
          .forEachOrdered(picture -> scenario.embed(picture, MEDIA_TYPE, scenario.getName()));
      screenshotTaker.clear();
    });

    After(scenario -> {

      if (scenario.isFailed()) {

        context.<ValidatableResponse>get(Key.VALIDATABLE_RESPONSE)
            .ifPresent(response -> scenario.write(response.extract().response().asString()));
        screenshotTaker.takeScreenshot();
        screenshotTaker.getAll()
            .forEachOrdered(picture -> scenario.embed(picture, MEDIA_TYPE, scenario.getName()));
      }

      context.<WebDriverContainer>get(Key.BROWSER_WEBDRIVER_CONTAINER)
          .map(WebDriverContainer::getWebDriver)
          .ifPresent(WebDriver::quit);
      screenshotTaker.clear();
      reporter.clear();
      context.clear();
    });
  }
}
