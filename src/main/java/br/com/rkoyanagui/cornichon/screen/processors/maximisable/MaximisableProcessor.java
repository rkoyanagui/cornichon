package br.com.rkoyanagui.cornichon.screen.processors.maximisable;

import br.com.rkoyanagui.cornichon.screen.interactions.Maximisable;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;
import java.util.function.Predicate;
import lombok.NonNull;

public abstract class MaximisableProcessor {

  protected final MaximisableProcessor nextProcessor;
  protected final Predicate<WebDriverContainer> webDriverContainerPredicate;

  public MaximisableProcessor(
      MaximisableProcessor nextProcessor,
      @NonNull Predicate<WebDriverContainer> webDriverContainerPredicate) {

    this.nextProcessor = nextProcessor;
    this.webDriverContainerPredicate = webDriverContainerPredicate;
  }

  public static MaximisableProcessor getChain() {
    return new BrowserMaximisableProcessor();
  }

  public abstract void maximise(Maximisable<?> element);
}
