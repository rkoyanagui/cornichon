package br.com.rkoyanagui.cornichon.screen.elements;

import br.com.rkoyanagui.cornichon.screen.interactions.Clickable;
import br.com.rkoyanagui.cornichon.screen.interactions.Locatable;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;
import br.com.rkoyanagui.cornichon.screen.processors.clickable.ClickableProcessor;
import br.com.rkoyanagui.cornichon.screen.processors.visible.VisibleProcessor;
import java.util.Optional;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.By;

@Getter
abstract class ScreenElement<S extends ScreenElement<S>> implements Clickable<S> {

  private WebDriverContainer webDriverContainer;
  private Locatable parent;
  private By locator;
  private VisibleProcessor visibleProcessor;
  private ClickableProcessor clickableProcessor;

  ScreenElement(@NonNull WebDriverContainer webDriverContainer,
      Locatable parent,
      @NonNull By locator) {

    this.webDriverContainer = webDriverContainer;
    this.parent = parent;
    this.locator = locator;
    this.visibleProcessor = VisibleProcessor.getChain();
    this.clickableProcessor = ClickableProcessor.getChain();
  }

  @Override
  public Optional<Locatable> getParent() {
    return Optional.ofNullable(parent);
  }
}
