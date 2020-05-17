package br.com.rkoyanagui.cornichon.screen.processors.maximisable;

import static java.util.Objects.nonNull;

import br.com.rkoyanagui.cornichon.screen.interactions.Maximisable;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.BrowserWebDriverContainer;

public final class BrowserMaximisableProcessor extends MaximisableProcessor {

  public BrowserMaximisableProcessor(MaximisableProcessor nextProcessor) {
    super(nextProcessor, container -> container instanceof BrowserWebDriverContainer);
  }

  public BrowserMaximisableProcessor() {
    super(null, container -> container instanceof BrowserWebDriverContainer);
  }

  @Override
  public void maximise(Maximisable<?> element) {

    if (webDriverContainerPredicate.test(element.getWebDriverContainer())) {
      element.getWebDriverContainer()
          .getWebDriver()
          .manage()
          .window()
          .maximize();

    } else if (nonNull(nextProcessor)) {
      nextProcessor.maximise(element);

    } else {
      throw new MaximisableProcessorNotFoundException(element.getWebDriverContainer().getClass());
    }
  }
}
