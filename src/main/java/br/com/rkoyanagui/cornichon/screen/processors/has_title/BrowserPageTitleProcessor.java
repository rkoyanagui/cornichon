package br.com.rkoyanagui.cornichon.screen.processors.has_title;

import static java.util.Objects.nonNull;

import br.com.rkoyanagui.cornichon.screen.interactions.HasTitle;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.BrowserWebDriverContainer;

public final class BrowserPageTitleProcessor extends PageTitleProcessor {

  public BrowserPageTitleProcessor(PageTitleProcessor nextProcessor) {
    super(nextProcessor, container -> container instanceof BrowserWebDriverContainer);
  }

  public BrowserPageTitleProcessor() {
    super(null, container -> container instanceof BrowserWebDriverContainer);
  }

  @Override
  public String getTitle(HasTitle element) {

    if (webDriverContainerPredicate.test(element.getWebDriverContainer())) {
      return element.getWebDriverContainer().getWebDriver().getTitle();

    } else if (nonNull(nextProcessor)) {
      return nextProcessor.getTitle(element);

    } else {
      throw new PageTitleProcessorNotFoundException(element.getWebDriverContainer().getClass());
    }
  }
}
