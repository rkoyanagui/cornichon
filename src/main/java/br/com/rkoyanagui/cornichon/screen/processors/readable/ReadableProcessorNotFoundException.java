package br.com.rkoyanagui.cornichon.screen.processors.readable;

import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;

public class ReadableProcessorNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 2851707607590739076L;

  public ReadableProcessorNotFoundException(String message) {
    super(message);
  }

  public ReadableProcessorNotFoundException(Throwable cause) {
    super(cause);
  }

  public ReadableProcessorNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public ReadableProcessorNotFoundException(Class<? extends WebDriverContainer> clazz) {
    super("No 'ReadableProcessor' was found for the class: " + clazz.getName());
  }
}
