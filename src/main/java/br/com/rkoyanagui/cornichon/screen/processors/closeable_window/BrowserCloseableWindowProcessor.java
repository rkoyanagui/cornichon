package br.com.rkoyanagui.cornichon.screen.processors.closeable_window;

import static java.util.Objects.nonNull;

import br.com.rkoyanagui.cornichon.screen.interactions.CloseableWindow;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.BrowserWebDriverContainer;

public final class BrowserCloseableWindowProcessor extends CloseableWindowProcessor {

  public BrowserCloseableWindowProcessor(CloseableWindowProcessor nextProcessor) {
    super(nextProcessor, container -> container instanceof BrowserWebDriverContainer);
  }

  public BrowserCloseableWindowProcessor() {
    super(null, container -> container instanceof BrowserWebDriverContainer);
  }

  @Override
  public void closeWindow(CloseableWindow element) {

    if (webDriverContainerPredicate.test(element.getWebDriverContainer())) {
      element.getWebDriverContainer().getWebDriver().close();

    } else if (nonNull(nextProcessor)) {
      nextProcessor.closeWindow(element);

    } else {
      throw new CloseableWindowProcessorNotFoundException(
          element.getWebDriverContainer().getClass());
    }
  }
}
