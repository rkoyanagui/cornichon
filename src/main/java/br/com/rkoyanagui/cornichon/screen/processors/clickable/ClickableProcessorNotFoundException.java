package br.com.rkoyanagui.cornichon.screen.processors.clickable;

import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;

public class ClickableProcessorNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 7108924660454722488L;

  public ClickableProcessorNotFoundException(String message) {
    super(message);
  }

  public ClickableProcessorNotFoundException(Throwable cause) {
    super(cause);
  }

  public ClickableProcessorNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public ClickableProcessorNotFoundException(Class<? extends WebDriverContainer> clazz) {
    super("No 'ClickableProcessor' was found for the class: " + clazz.getName());
  }
}
