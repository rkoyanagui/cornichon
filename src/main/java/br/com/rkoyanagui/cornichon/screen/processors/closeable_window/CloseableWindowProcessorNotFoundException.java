package br.com.rkoyanagui.cornichon.screen.processors.closeable_window;

import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;

public class CloseableWindowProcessorNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -849234526323144191L;

  public CloseableWindowProcessorNotFoundException(String message) {
    super(message);
  }

  public CloseableWindowProcessorNotFoundException(Throwable cause) {
    super(cause);
  }

  public CloseableWindowProcessorNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public CloseableWindowProcessorNotFoundException(Class<? extends WebDriverContainer> clazz) {
    super("No 'CloseableWindowProcessor' was found for the class: " + clazz.getName());
  }
}
