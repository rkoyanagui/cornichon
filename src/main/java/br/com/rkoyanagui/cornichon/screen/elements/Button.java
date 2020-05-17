package br.com.rkoyanagui.cornichon.screen.elements;

import br.com.rkoyanagui.cornichon.screen.interactions.Locatable;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;
import org.openqa.selenium.By;

public class Button extends ScreenElement<Button> {

  public Button(WebDriverContainer webDriverContainer,
      Locatable parent,
      By locator) {

    super(webDriverContainer, parent, locator);
  }
}
