package br.com.rkoyanagui.cornichon.screen.elements;

import br.com.rkoyanagui.cornichon.screen.interactions.Locatable;
import br.com.rkoyanagui.cornichon.screen.interactions.Writable;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;
import br.com.rkoyanagui.cornichon.screen.processors.readable.ReadableProcessor;
import br.com.rkoyanagui.cornichon.screen.processors.writable.WritableProcessor;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class TextField extends ScreenElement<TextField> implements Writable<TextField> {

  private ReadableProcessor readableProcessor;
  private WritableProcessor writableProcessor;

  public TextField(WebDriverContainer webDriverContainer,
      Locatable parent,
      By locator) {

    super(webDriverContainer, parent, locator);
    this.readableProcessor = ReadableProcessor.getChain();
    this.writableProcessor = WritableProcessor.getChain();
  }
}
