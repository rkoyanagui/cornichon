package br.com.rkoyanagui.cornichon.screen.processors.visible;

import static br.com.rkoyanagui.cornichon.screen.interactions.Visible.displayed;
import static br.com.rkoyanagui.cornichon.screen.interactions.Waitable.willWait;
import static java.util.Objects.nonNull;

import br.com.rkoyanagui.cornichon.screen.interactions.Visible;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.BrowserWebDriverContainer;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public final class BrowserVisibleProcessor extends VisibleProcessor {

  public BrowserVisibleProcessor(VisibleProcessor nextProcessor) {
    super(nextProcessor, container -> container instanceof BrowserWebDriverContainer);
  }

  public BrowserVisibleProcessor() {
    super(null, container -> container instanceof BrowserWebDriverContainer);
  }

  @Override
  public boolean isDisplayed(Visible<?> element) {

    if (webDriverContainerPredicate.test(element.getWebDriverContainer())) {
      return element.locate()
          .map(webElement -> webElement.isDisplayed()
              && webElement.getSize().getHeight() > 0
              && webElement.getSize().getWidth() > 0)
          .orElse(false);

    } else if (nonNull(nextProcessor)) {
      return nextProcessor.isDisplayed(element);

    } else {
      throw new VisibleProcessorNotFoundException(element.getWebDriverContainer().getClass());
    }
  }

  @Override
  public void scrollDownTo(Visible<?> element) {

    if (webDriverContainerPredicate.test(element.getWebDriverContainer())) {
      scrollTo(element, Keys.ARROW_DOWN);

    } else if (nonNull(nextProcessor)) {
      nextProcessor.scrollDownTo(element);

    } else {
      throw new VisibleProcessorNotFoundException(element.getWebDriverContainer().getClass());
    }
  }

  @Override
  public void scrollUpTo(Visible<?> element) {

    if (webDriverContainerPredicate.test(element.getWebDriverContainer())) {
      scrollTo(element, Keys.ARROW_UP);

    } else if (nonNull(nextProcessor)) {
      nextProcessor.scrollUpTo(element);

    } else {
      throw new VisibleProcessorNotFoundException(element.getWebDriverContainer().getClass());
    }
  }

  protected void scrollTo(Visible<?> element, Keys key) {

    willWait()
        .until(() -> element, displayed())
        .locate()
        .ifPresent(webElement -> new Actions(element.getWebDriverContainer().getWebDriver())
            .moveToElement(webElement)
            .sendKeys(key)
            .perform());
  }
}
