package br.com.rkoyanagui.cornichon.screen.processors.maximisable;

import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;

public class MaximisableProcessorNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -3122211404063478686L;

  public MaximisableProcessorNotFoundException(String message) {
    super(message);
  }

  public MaximisableProcessorNotFoundException(Throwable cause) {
    super(cause);
  }

  public MaximisableProcessorNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public MaximisableProcessorNotFoundException(Class<? extends WebDriverContainer> clazz) {
    super("No 'MaximisableProcessor' was found for the class: " + clazz.getName());
  }
}
