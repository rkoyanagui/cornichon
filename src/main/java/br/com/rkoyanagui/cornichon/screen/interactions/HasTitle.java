package br.com.rkoyanagui.cornichon.screen.interactions;

import static java.util.Objects.nonNull;

import br.com.rkoyanagui.cornichon.screen.processors.has_title.PageTitleProcessor;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public interface HasTitle extends Locatable {

  PageTitleProcessor getPageTitleProcessor();

  default String getTitle() {
    return getPageTitleProcessor().getTitle(this);
  }

  static HasTitleMatcher hasTitle() {
    return new HasTitleMatcher();
  }

  class HasTitleMatcher extends BaseMatcher<HasTitle> {

    @Override
    public boolean matches(Object actual) {
      if (nonNull(actual) && (actual instanceof HasTitle)) {
        HasTitle element = (HasTitle) actual;
        return nonNull(element.getTitle());
      }
      return false;
    }

    @Override
    public void describeTo(Description description) {
      description.appendText("a screen document containing a title element");
    }
  }
}
