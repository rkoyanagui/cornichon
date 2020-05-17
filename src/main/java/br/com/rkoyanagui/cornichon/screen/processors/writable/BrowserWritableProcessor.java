package br.com.rkoyanagui.cornichon.screen.processors.writable;

import static br.com.rkoyanagui.cornichon.screen.interactions.Clickable.clickable;
import static br.com.rkoyanagui.cornichon.screen.interactions.Waitable.willWait;
import static java.util.Objects.nonNull;

import br.com.rkoyanagui.cornichon.screen.interactions.Writable;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.BrowserWebDriverContainer;
import org.openqa.selenium.interactions.Actions;

public final class BrowserWritableProcessor extends WritableProcessor {

  public BrowserWritableProcessor(WritableProcessor nextProcessor) {
    super(nextProcessor, container -> container instanceof BrowserWebDriverContainer);
  }

  public BrowserWritableProcessor() {
    super(null, container -> container instanceof BrowserWebDriverContainer);
  }

  @Override
  public void write(Writable<?> element, String text) {

    if (nonNull(text) && !text.isEmpty()) {

      if (webDriverContainerPredicate.test(element.getWebDriverContainer())) {
        willWait()
            .until(() -> element, clickable())
            .locate()
            .ifPresent(webElement -> new Actions(element.getWebDriverContainer().getWebDriver())
                .moveToElement(webElement)
                .sendKeys(webElement, text)
                .perform());

      } else if (nonNull(nextProcessor)) {
        nextProcessor.write(element, text);

      } else {
        throw new WritableProcessorNotFoundException(element.getWebDriverContainer().getClass());
      }
    }
  }

  @Override
  public void write(Writable<?> element, String text, long pauseInMilli) {

    if (nonNull(text) && !text.isEmpty()) {

      if (webDriverContainerPredicate.test(element.getWebDriverContainer())) {
        willWait()
            .until(() -> element, clickable())
            .locate()
            .ifPresent(webElement -> {
              Actions actions = new Actions(element.getWebDriverContainer().getWebDriver())
                  .moveToElement(webElement);
              for (int i = 0; i < text.length(); i++) {
                actions = actions.pause(pauseInMilli)
                    .sendKeys(webElement, text.substring(i, i + 1));
              }
              actions.perform();
            });

      } else if (nonNull(nextProcessor)) {
        nextProcessor.write(element, text, pauseInMilli);

      } else {
        throw new WritableProcessorNotFoundException(element.getWebDriverContainer().getClass());
      }
    }
  }

  @Override
  public void clear(Writable<?> element) {

    if (webDriverContainerPredicate.test(element.getWebDriverContainer())) {
      willWait()
          .until(() -> element, clickable())
          .locate()
          .ifPresent(webElement -> {
            new Actions(element.getWebDriverContainer().getWebDriver())
                .moveToElement(webElement)
                .perform();
            webElement.clear();
          });

    } else if (nonNull(nextProcessor)) {
      nextProcessor.clear(element);

    } else {
      throw new WritableProcessorNotFoundException(element.getWebDriverContainer().getClass());
    }
  }

  @Override
  public void submit(Writable<?> element) {

    if (webDriverContainerPredicate.test(element.getWebDriverContainer())) {
      willWait()
          .until(() -> element, clickable())
          .locate()
          .ifPresent(webElement -> {
            new Actions(element.getWebDriverContainer().getWebDriver())
                .moveToElement(webElement)
                .perform();
            webElement.submit();
          });

    } else if (nonNull(nextProcessor)) {
      nextProcessor.submit(element);

    } else {
      throw new WritableProcessorNotFoundException(element.getWebDriverContainer().getClass());
    }
  }
}
