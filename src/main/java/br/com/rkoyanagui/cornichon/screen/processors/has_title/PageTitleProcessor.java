package br.com.rkoyanagui.cornichon.screen.processors.has_title;

import br.com.rkoyanagui.cornichon.screen.interactions.HasTitle;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;
import java.util.function.Predicate;
import lombok.NonNull;

public abstract class PageTitleProcessor {

  protected PageTitleProcessor nextProcessor;
  protected Predicate<WebDriverContainer> webDriverContainerPredicate;

  public PageTitleProcessor(
      PageTitleProcessor nextProcessor,
      @NonNull Predicate<WebDriverContainer> webDriverContainerPredicate) {

    this.nextProcessor = nextProcessor;
    this.webDriverContainerPredicate = webDriverContainerPredicate;
  }

  public static PageTitleProcessor getChain() {
    return new BrowserPageTitleProcessor();
  }

  public abstract String getTitle(HasTitle element);
}
