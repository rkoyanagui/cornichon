package br.com.rkoyanagui.cornichon.screen.elements;

import br.com.rkoyanagui.cornichon.screen.interactions.Locatable;
import br.com.rkoyanagui.cornichon.screen.interactions.Readable;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;
import br.com.rkoyanagui.cornichon.screen.processors.readable.ReadableProcessor;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class Text extends ScreenElement<Text> implements Readable<Text> {

  private ReadableProcessor readableProcessor;

  public Text(WebDriverContainer webDriverContainer,
      Locatable parent,
      By locator) {

    super(webDriverContainer, parent, locator);
    this.readableProcessor = ReadableProcessor.getChain();
  }
}
