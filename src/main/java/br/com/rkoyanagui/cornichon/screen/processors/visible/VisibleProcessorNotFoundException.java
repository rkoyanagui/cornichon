package br.com.rkoyanagui.cornichon.screen.processors.visible;

import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;

public class VisibleProcessorNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1529466606573966476L;

  public VisibleProcessorNotFoundException(String message) {
    super(message);
  }

  public VisibleProcessorNotFoundException(Throwable cause) {
    super(cause);
  }

  public VisibleProcessorNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public VisibleProcessorNotFoundException(Class<? extends WebDriverContainer> clazz) {
    super("No 'VisibleProcessor' was found for the class: " + clazz.getName());
  }
}
