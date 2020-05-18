package br.com.rkoyanagui.cornichon.screen.elements;

import br.com.rkoyanagui.cornichon.screen.interactions.Locatable;
import br.com.rkoyanagui.cornichon.screen.interactions.Writable;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public final class TextField extends ScreenElement<TextField> implements Writable<TextField> {

  public TextField(WebDriverContainer webDriverContainer,
      Locatable parent,
      By locator) {

    super(webDriverContainer, parent, locator);
  }
}
