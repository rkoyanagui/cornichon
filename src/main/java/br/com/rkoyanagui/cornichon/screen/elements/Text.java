package br.com.rkoyanagui.cornichon.screen.elements;

import br.com.rkoyanagui.cornichon.screen.interactions.Locatable;
import br.com.rkoyanagui.cornichon.screen.interactions.Readable;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public final class Text extends ScreenElement<Text> implements Readable<Text> {

  public Text(WebDriverContainer webDriverContainer,
      Locatable parent,
      By locator) {

    super(webDriverContainer, parent, locator);
  }
}
