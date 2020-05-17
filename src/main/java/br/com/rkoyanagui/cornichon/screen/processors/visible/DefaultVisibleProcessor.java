package br.com.rkoyanagui.cornichon.screen.processors.visible;

import static java.util.Objects.nonNull;

import br.com.rkoyanagui.cornichon.screen.interactions.Visible;
import java.util.Objects;

public final class DefaultVisibleProcessor extends VisibleProcessor {

  public DefaultVisibleProcessor(VisibleProcessor nextProcessor) {
    super(nextProcessor, Objects::nonNull);
  }

  public DefaultVisibleProcessor() {
    super(null, Objects::nonNull);
  }

  @Override
  public boolean isDisplayed(Visible<?> element) {

    if (webDriverContainerPredicate.test(element.getWebDriverContainer())) {
      // TODO
      return false;

    } else if (nonNull(nextProcessor)) {
      return nextProcessor.isDisplayed(element);

    } else {
      throw new VisibleProcessorNotFoundException(element.getWebDriverContainer().getClass());
    }
  }

  @Override
  public void scrollDownTo(Visible<?> element) {

    if (webDriverContainerPredicate.test(element.getWebDriverContainer())) {
      // TODO

    } else if (nonNull(nextProcessor)) {
      nextProcessor.scrollDownTo(element);

    } else {
      throw new VisibleProcessorNotFoundException(element.getWebDriverContainer().getClass());
    }
  }

  @Override
  public void scrollUpTo(Visible<?> element) {

    if (webDriverContainerPredicate.test(element.getWebDriverContainer())) {
      // TODO

    } else if (nonNull(nextProcessor)) {
      nextProcessor.scrollUpTo(element);

    } else {
      throw new VisibleProcessorNotFoundException(element.getWebDriverContainer().getClass());
    }
  }
}
