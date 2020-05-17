package br.com.rkoyanagui.cornichon.screen.selenium;

public class WebDriverFactoryException extends RuntimeException {

  private static final long serialVersionUID = -4505802554479782155L;

  public WebDriverFactoryException(String message) {
    super(message);
  }

  public WebDriverFactoryException(String message, Throwable cause) {
    super(message, cause);
  }

  public WebDriverFactoryException(Throwable cause) {
    super(cause);
  }
}
