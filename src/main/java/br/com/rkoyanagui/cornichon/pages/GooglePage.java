package br.com.rkoyanagui.cornichon.pages;

import br.com.rkoyanagui.cornichon.screen.elements.Page;
import br.com.rkoyanagui.cornichon.screen.elements.TextField;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public final class GooglePage extends Page<GooglePage> {

  public static final String URL = "https://www.google.com";
  private final TextField fldQueryBar = new TextField(getWebDriverContainer(), this, By.name("q"));

  public GooglePage(WebDriverContainer webDriverContainer) {
    super(webDriverContainer);
  }
}
