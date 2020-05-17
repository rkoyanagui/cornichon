package br.com.rkoyanagui.cornichon.screen.processors.clickable;

import static br.com.rkoyanagui.cornichon.screen.interactions.Clickable.clickable;
import static br.com.rkoyanagui.cornichon.screen.interactions.Waitable.willWait;
import static java.util.Objects.nonNull;

import br.com.rkoyanagui.cornichon.screen.interactions.Clickable;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.BrowserWebDriverContainer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public final class BrowserClickableProcessor extends ClickableProcessor {

  public BrowserClickableProcessor(ClickableProcessor nextProcessor) {
    super(nextProcessor, container -> container instanceof BrowserWebDriverContainer);
  }

  public BrowserClickableProcessor() {
    super(null, container -> container instanceof BrowserWebDriverContainer);
  }

  @Override
  public boolean isClickable(Clickable<?> element) {

    if (webDriverContainerPredicate.test(element.getWebDriverContainer())) {
      return element.isDisplayed() && element.locate().map(WebElement::isEnabled).orElse(false);

    } else if (nonNull(nextProcessor)) {
      return nextProcessor.isClickable(element);

    } else {
      throw new ClickableProcessorNotFoundException(element.getWebDriverContainer().getClass());
    }
  }

  @Override
  public void click(Clickable<?> element) {

    if (webDriverContainerPredicate.test(element.getWebDriverContainer())) {
      willWait()
          .until(() -> element, clickable())
          .locate()
          .ifPresent(webElement -> new Actions(element.getWebDriverContainer().getWebDriver())
              .click(webElement).perform());

    } else if (nonNull(nextProcessor)) {
      nextProcessor.click(element);

    } else {
      throw new ClickableProcessorNotFoundException(element.getWebDriverContainer().getClass());
    }
  }
}
