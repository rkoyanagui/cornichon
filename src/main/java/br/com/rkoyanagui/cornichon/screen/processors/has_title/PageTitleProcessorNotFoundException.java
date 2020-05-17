package br.com.rkoyanagui.cornichon.screen.processors.has_title;

import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;

public class PageTitleProcessorNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 8954859193790482420L;

  public PageTitleProcessorNotFoundException(String message) {
    super(message);
  }

  public PageTitleProcessorNotFoundException(Throwable cause) {
    super(cause);
  }

  public PageTitleProcessorNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public PageTitleProcessorNotFoundException(Class<? extends WebDriverContainer> clazz) {
    super("No 'HasTitleProcessor' was found for the class: " + clazz.getName());
  }
}
