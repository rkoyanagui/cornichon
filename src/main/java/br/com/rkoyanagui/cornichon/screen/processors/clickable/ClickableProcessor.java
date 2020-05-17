package br.com.rkoyanagui.cornichon.screen.processors.clickable;

import br.com.rkoyanagui.cornichon.screen.interactions.Clickable;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;
import java.util.function.Predicate;
import lombok.NonNull;

public abstract class ClickableProcessor {

  protected ClickableProcessor nextProcessor;
  protected Predicate<WebDriverContainer> webDriverContainerPredicate;

  public ClickableProcessor(ClickableProcessor nextProcessor,
      @NonNull Predicate<WebDriverContainer> webDriverContainerPredicate) {

    this.nextProcessor = nextProcessor;
    this.webDriverContainerPredicate = webDriverContainerPredicate;
  }

  public static ClickableProcessor getChain() {
    return new BrowserClickableProcessor();
  }

  public abstract boolean isClickable(Clickable<?> element);

  public abstract void click(Clickable<?> element);
}
