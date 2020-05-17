package br.com.rkoyanagui.cornichon.screen.processors.readable;

import static br.com.rkoyanagui.cornichon.screen.interactions.Visible.displayed;
import static br.com.rkoyanagui.cornichon.screen.interactions.Waitable.willWait;
import static java.util.Objects.nonNull;

import br.com.rkoyanagui.cornichon.screen.interactions.Readable;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.BrowserWebDriverContainer;
import org.openqa.selenium.interactions.Actions;

public final class BrowserReadableProcessor extends ReadableProcessor {

  public BrowserReadableProcessor(ReadableProcessor nextProcessor) {
    super(nextProcessor, container -> container instanceof BrowserWebDriverContainer);
  }

  public BrowserReadableProcessor() {
    super(null, container -> container instanceof BrowserWebDriverContainer);
  }

  @Override
  public String read(Readable<?> element) {

    if (webDriverContainerPredicate.test(element.getWebDriverContainer())) {
      return willWait()
          .until(() -> element, displayed())
          .locate()
          .map(webElement -> {
            new Actions(element.getWebDriverContainer().getWebDriver())
                .moveToElement(webElement)
                .perform();
            return webElement.getText();
          })
          .orElse("");

    } else if (nonNull(nextProcessor)) {
      return nextProcessor.read(element);

    } else {
      throw new ReadableProcessorNotFoundException(element.getWebDriverContainer().getClass());
    }
  }
}
