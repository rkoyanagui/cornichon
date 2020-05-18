package br.com.rkoyanagui.cornichon.screen.processors.visible;

import br.com.rkoyanagui.cornichon.screen.interactions.Visible;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;
import java.util.function.Predicate;
import lombok.NonNull;

public abstract class VisibleProcessor {

  protected final VisibleProcessor nextProcessor;
  protected final Predicate<WebDriverContainer> webDriverContainerPredicate;

  public VisibleProcessor(VisibleProcessor nextProcessor,
      @NonNull Predicate<WebDriverContainer> webDriverContainerPredicate) {

    this.nextProcessor = nextProcessor;
    this.webDriverContainerPredicate = webDriverContainerPredicate;
  }

  public static VisibleProcessor getChain() {
    return new BrowserVisibleProcessor(new DefaultVisibleProcessor());
  }

  public abstract boolean isDisplayed(Visible<?> element);

  public abstract void scrollDownTo(Visible<?> element);

  public abstract void scrollUpTo(Visible<?> element);
}
