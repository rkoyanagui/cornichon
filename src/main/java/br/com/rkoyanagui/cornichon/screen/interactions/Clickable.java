package br.com.rkoyanagui.cornichon.screen.interactions;

import static java.util.Objects.nonNull;

import br.com.rkoyanagui.cornichon.screen.processors.clickable.ClickableProcessor;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public interface Clickable<C extends Clickable<C>> extends Visible<C> {

  default ClickableProcessor getClickableProcessor() {
    return DefaultChains.CLICKABLE_PROCESSOR_CHAIN;
  }

  default boolean isClickable() {
    return getClickableProcessor().isClickable(this);
  }

  default C click() {
    getClickableProcessor().click(this);
    return (C) this;
  }

  static ClickableMatcher clickable() {
    return new ClickableMatcher();
  }

  class ClickableMatcher extends BaseMatcher<Clickable<?>> {

    @Override
    public boolean matches(Object actual) {
      if (nonNull(actual) && actual instanceof Clickable<?>) {
        return ((Clickable<?>) actual).isClickable();
      }
      return false;
    }

    @Override
    public void describeTo(Description description) {
      description.appendText("a clickable screen element");
    }
  }
}
