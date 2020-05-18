package br.com.rkoyanagui.cornichon.screen.processors.closeable_window;

import br.com.rkoyanagui.cornichon.screen.interactions.CloseableWindow;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;
import java.util.function.Predicate;
import lombok.NonNull;

public abstract class CloseableWindowProcessor {

  protected final CloseableWindowProcessor nextProcessor;
  protected final Predicate<WebDriverContainer> webDriverContainerPredicate;

  public CloseableWindowProcessor(
      CloseableWindowProcessor nextProcessor,
      @NonNull Predicate<WebDriverContainer> webDriverContainerPredicate) {

    this.nextProcessor = nextProcessor;
    this.webDriverContainerPredicate = webDriverContainerPredicate;
  }

  public static CloseableWindowProcessor getChain() {
    return new BrowserCloseableWindowProcessor();
  }

  public abstract void closeWindow(CloseableWindow element);
}
