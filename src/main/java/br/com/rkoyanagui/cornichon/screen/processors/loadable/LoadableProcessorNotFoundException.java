package br.com.rkoyanagui.cornichon.screen.processors.loadable;

import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;

public class LoadableProcessorNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -5625367059521557543L;

  public LoadableProcessorNotFoundException(String message) {
    super(message);
  }

  public LoadableProcessorNotFoundException(Throwable cause) {
    super(cause);
  }

  public LoadableProcessorNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public LoadableProcessorNotFoundException(Class<? extends WebDriverContainer> clazz) {
    super("No 'LoadableProcessor' was found for the class: " + clazz.getName());
  }
}
