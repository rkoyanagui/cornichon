package br.com.rkoyanagui.cornichon.screen.elements;

import static br.com.rkoyanagui.cornichon.screen.interactions.Waitable.willWait;

import br.com.rkoyanagui.cornichon.screen.interactions.Locatable;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;
import java.util.Optional;
import lombok.Getter;
import lombok.NonNull;
import org.hamcrest.Matcher;
import org.openqa.selenium.By;

@Getter
public abstract class ScreenElement<S extends ScreenElement<S>> implements Locatable {

  private final WebDriverContainer webDriverContainer;
  private final Locatable parent;
  private final By locator;

  public ScreenElement(@NonNull WebDriverContainer webDriverContainer,
      Locatable parent,
      @NonNull By locator) {

    this.webDriverContainer = webDriverContainer;
    this.parent = parent;
    this.locator = locator;
  }

  @Override
  public Optional<Locatable> getParent() {
    return Optional.ofNullable(parent);
  }

  public S waitUntil(Matcher<? super S> matcher) {
    return willWait().until(() -> (S) this, matcher);
  }

  public S waitUntil(long timeoutInSeconds) {
    willWait(timeoutInSeconds);
    return (S) this;
  }
}
