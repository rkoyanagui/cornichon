package br.com.rkoyanagui.cornichon.screen.elements;

import br.com.rkoyanagui.cornichon.screen.interactions.Clickable;
import br.com.rkoyanagui.cornichon.screen.interactions.Locatable;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;
import java.util.Optional;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.By;

@Getter
public abstract class ScreenElement<S extends ScreenElement<S>> implements Clickable<S> {

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
}
