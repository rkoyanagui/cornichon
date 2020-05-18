package br.com.rkoyanagui.cornichon.screen.processors.readable;

import br.com.rkoyanagui.cornichon.screen.interactions.Readable;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;
import java.util.function.Predicate;
import lombok.NonNull;

public abstract class ReadableProcessor {

  protected final ReadableProcessor nextProcessor;
  protected final Predicate<WebDriverContainer> webDriverContainerPredicate;

  public ReadableProcessor(
      ReadableProcessor nextProcessor,
      @NonNull Predicate<WebDriverContainer> webDriverContainerPredicate) {

    this.nextProcessor = nextProcessor;
    this.webDriverContainerPredicate = webDriverContainerPredicate;
  }

  public static ReadableProcessor getChain() {
    return new BrowserReadableProcessor();
  }

  public abstract String read(Readable<?> element);
}
