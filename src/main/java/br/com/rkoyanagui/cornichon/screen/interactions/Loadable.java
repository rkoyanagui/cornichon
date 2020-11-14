package br.com.rkoyanagui.cornichon.screen.interactions;

import static java.util.Objects.nonNull;

import br.com.rkoyanagui.cornichon.screen.processors.loadable.LoadableProcessor;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public interface Loadable<L extends Loadable<L>> extends Locatable {

  default LoadableProcessor getLoadableProcessor() {
    return DefaultChains.LOADABLE_PROCESSOR_CHAIN;
  }

  default boolean hasBeenLoaded() {
    return getLoadableProcessor().hasBeenLoaded(this);
  }

  default L load(String url) {
    getLoadableProcessor().load(this, url);
    return (L) this;
  }

  default String getCurrentUrl() {
    return getLoadableProcessor().getCurrentUrl(this);
  }

  static LoadableMatcher loaded() {
    return new LoadableMatcher();
  }

  class LoadableMatcher extends BaseMatcher<Loadable<?>> {

    @Override
    public boolean matches(Object actual) {
      if (nonNull(actual) && actual instanceof Loadable<?>) {
        return ((Loadable<?>) actual).hasBeenLoaded();
      }
      return false;
    }

    @Override
    public void describeTo(Description description) {
      description.appendText("a window that has already been loaded");
    }
  }
}
