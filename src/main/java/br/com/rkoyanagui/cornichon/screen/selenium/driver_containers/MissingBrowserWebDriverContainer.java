package br.com.rkoyanagui.cornichon.screen.selenium.driver_containers;

public class MissingBrowserWebDriverContainer extends IllegalStateException {

  private static final long serialVersionUID = 8562724209289704845L;

  public MissingBrowserWebDriverContainer() {
    this("Missing 'browser_webdriver_container'!");
  }

  public MissingBrowserWebDriverContainer(String s) {
    super(s);
  }

  public MissingBrowserWebDriverContainer(String message, Throwable cause) {
    super(message, cause);
  }

  public MissingBrowserWebDriverContainer(Throwable cause) {
    super(cause);
  }
}
