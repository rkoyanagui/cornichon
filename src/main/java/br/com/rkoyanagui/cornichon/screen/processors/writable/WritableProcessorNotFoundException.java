package br.com.rkoyanagui.cornichon.screen.processors.writable;

import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;

public class WritableProcessorNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 6980504466449660051L;

  public WritableProcessorNotFoundException(String message) {
    super(message);
  }

  public WritableProcessorNotFoundException(Throwable cause) {
    super(cause);
  }

  public WritableProcessorNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public WritableProcessorNotFoundException(Class<? extends WebDriverContainer> clazz) {
    super("No 'WritableProcessor' was found for the class: " + clazz.getName());
  }
}
