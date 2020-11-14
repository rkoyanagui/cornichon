package br.com.rkoyanagui.cornichon.screen.processors.loadable;

import static java.util.Objects.nonNull;

import br.com.rkoyanagui.cornichon.screen.interactions.Loadable;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.BrowserWebDriverContainer;
import java.util.Optional;
import org.openqa.selenium.JavascriptExecutor;

public final class BrowserLoadableProcessor extends LoadableProcessor {

  public BrowserLoadableProcessor(LoadableProcessor nextProcessor) {
    super(nextProcessor, container -> container instanceof BrowserWebDriverContainer);
  }

  public BrowserLoadableProcessor() {
    super(null, container -> container instanceof BrowserWebDriverContainer);
  }

  @Override
  public boolean hasBeenLoaded(Loadable<?> element) {
    return isInReadyState(element) && hasInactiveJQuery(element);
  }

  protected boolean isInReadyState(Loadable<?> element) {
    return Optional.ofNullable(((JavascriptExecutor) element.getWebDriverContainer().getWebDriver())
        .executeScript("return document.readyState"))
        .map("complete"::equals)
        .orElse(false);
  }

  protected boolean hasInactiveJQuery(Loadable<?> element) {

    JavascriptExecutor driver = (JavascriptExecutor) element.getWebDriverContainer().getWebDriver();

    return (boolean) driver.executeScript("return window.jQuery == undefined") ||
        (boolean) driver.executeScript("return jQuery.active == 0");
  }

  @Override
  public void load(Loadable<?> element, String url) {

    if (webDriverContainerPredicate.test(element.getWebDriverContainer())) {
      element.getWebDriverContainer().getWebDriver().get(url);

    } else if (nonNull(nextProcessor)) {
      nextProcessor.load(element, url);

    } else {
      throw new LoadableProcessorNotFoundException(element.getWebDriverContainer().getClass());
    }
  }

  @Override
  public String getCurrentUrl(Loadable<?> element) {

    if (webDriverContainerPredicate.test(element.getWebDriverContainer())) {
      return element.getWebDriverContainer().getWebDriver().getCurrentUrl();

    } else if (nonNull(nextProcessor)) {
      return nextProcessor.getCurrentUrl(element);

    } else {
      throw new LoadableProcessorNotFoundException(element.getWebDriverContainer().getClass());
    }
  }
}
