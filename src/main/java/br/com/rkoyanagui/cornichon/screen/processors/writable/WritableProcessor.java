package br.com.rkoyanagui.cornichon.screen.processors.writable;

import br.com.rkoyanagui.cornichon.screen.interactions.Writable;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;
import java.util.function.Predicate;
import lombok.NonNull;

public abstract class WritableProcessor {

  protected WritableProcessor nextProcessor;
  protected Predicate<WebDriverContainer> webDriverContainerPredicate;

  public WritableProcessor(
      WritableProcessor nextProcessor,
      @NonNull Predicate<WebDriverContainer> webDriverContainerPredicate) {

    this.nextProcessor = nextProcessor;
    this.webDriverContainerPredicate = webDriverContainerPredicate;
  }

  public static WritableProcessor getChain() {
    return new BrowserWritableProcessor();
  }

  public abstract void write(Writable<?> element, String text);

  public abstract void write(Writable<?> element, String text, long pauseInMilli);

  public abstract void clear(Writable<?> element);

  public abstract void submit(Writable<?> element);
}
