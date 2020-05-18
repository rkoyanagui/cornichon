package br.com.rkoyanagui.cornichon.screen.selenium.driver_containers;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverContainer {

  private final WebDriver webDriver;

  public WebDriverContainer(WebDriver webDriver) {
    this.webDriver = webDriver;
  }

  public WebDriver getWebDriver() {
    return webDriver;
  }
}
