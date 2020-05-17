package br.com.rkoyanagui.cornichon.screen.elements;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

import br.com.rkoyanagui.cornichon.screen.interactions.ScreenshotTaker;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;
import br.com.rkoyanagui.cornichon.utils.Context;
import br.com.rkoyanagui.cornichon.utils.Key;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;
import java.util.stream.Stream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class SeleniumScreenshotTaker implements ScreenshotTaker {

  private Context context;
  private Deque<byte[]> pictureStack;

  @Autowired
  protected SeleniumScreenshotTaker(Context context) {

    this.context = context;
    this.pictureStack = new ArrayDeque<>();
  }

  @Override
  public Optional<byte[]> takeScreenshot(WebDriverContainer webDriverContainer) {
    return Optional.ofNullable(webDriverContainer)
        .map(WebDriverContainer::getWebDriver)
        .map(driver -> ((TakesScreenshot) driver)
            .getScreenshotAs(OutputType.BYTES))
        .flatMap(this::push);
  }

  @Override
  public Optional<byte[]> takeScreenshot() {
    return context.<WebDriverContainer>get(Key.BROWSER_WEBDRIVER_CONTAINER)
        .flatMap(this::takeScreenshot);
  }

  @Override
  public Optional<byte[]> push(byte[] picture) {
    return Optional.ofNullable(picture).map(pic -> {
      pictureStack.push(pic);
      return pic;
    });
  }

  @Override
  public Optional<byte[]> pop() {
    return Optional.ofNullable(pictureStack).map(Deque::pop);
  }

  @Override
  public Stream<byte[]> getAll() {
    return pictureStack.stream();
  }

  @Override
  public void clear() {
    pictureStack.clear();
  }
}
