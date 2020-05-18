package br.com.rkoyanagui.cornichon.screen.interactions;

import static java.util.Objects.nonNull;

import br.com.rkoyanagui.cornichon.screen.processors.visible.VisibleProcessor;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public interface Visible<V extends Visible<V>> extends Locatable {

  default VisibleProcessor getVisibleProcessor() {
    return DefaultChains.VISIBLE_PROCESSOR_CHAIN;
  }

  default boolean isDisplayed() {
    return getVisibleProcessor().isDisplayed(this);
  }

  default V scrollDownTo() {
    getVisibleProcessor().scrollDownTo(this);
    return (V) this;
  }

  default V scrollUpTo() {
    getVisibleProcessor().scrollUpTo(this);
    return (V) this;
  }

  static DisplayedMatcher displayed() {
    return new DisplayedMatcher();
  }

  class DisplayedMatcher extends BaseMatcher<Visible<?>> {

    @Override
    public boolean matches(Object actual) {
      if (nonNull(actual) && (actual instanceof Visible<?>)) {
        Visible<?> element = (Visible<?>) actual;
        return element.isDisplayed();
      }
      return false;
    }

    @Override
    public void describeTo(Description description) {
      description.appendText("a visible screen element");
    }
  }
}
