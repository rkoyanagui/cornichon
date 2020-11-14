package br.com.rkoyanagui.cornichon.screen.elements;

import br.com.rkoyanagui.cornichon.screen.interactions.Clickable;
import br.com.rkoyanagui.cornichon.screen.interactions.Locatable;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;
import lombok.NonNull;
import org.openqa.selenium.By;

public final class Button extends ScreenElement<Button> implements Clickable<Button> {

  public Button(
      @NonNull WebDriverContainer webDriverContainer,
      Locatable parent, @NonNull By locator) {
    super(webDriverContainer, parent, locator);
  }
}
