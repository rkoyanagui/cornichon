package br.com.rkoyanagui.cornichon.screen.selenium.driver_containers;

import org.openqa.selenium.WebDriver;

public final class BrowserWebDriverContainer extends WebDriverContainer {

  public BrowserWebDriverContainer(WebDriver webDriver) {
    super(webDriver);
  }

  @Override
  public WebDriver getWebDriver() {
    return super.getWebDriver();
  }
}
