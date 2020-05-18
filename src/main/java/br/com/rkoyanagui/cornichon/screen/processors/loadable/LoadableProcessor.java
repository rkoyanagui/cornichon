package br.com.rkoyanagui.cornichon.screen.processors.loadable;

import br.com.rkoyanagui.cornichon.screen.interactions.Loadable;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;
import java.util.function.Predicate;
import lombok.NonNull;

public abstract class LoadableProcessor {

  protected final LoadableProcessor nextProcessor;
  protected final Predicate<WebDriverContainer> webDriverContainerPredicate;

  public LoadableProcessor(
      LoadableProcessor nextProcessor,
      @NonNull Predicate<WebDriverContainer> webDriverContainerPredicate) {

    this.nextProcessor = nextProcessor;
    this.webDriverContainerPredicate = webDriverContainerPredicate;
  }

  public static LoadableProcessor getChain() {
    return new BrowserLoadableProcessor();
  }

  public abstract boolean hasBeenLoaded(Loadable<?> element);

  public abstract void load(Loadable<?> element, String url);

  public abstract String getCurrentUrl(Loadable<?> element);
}
