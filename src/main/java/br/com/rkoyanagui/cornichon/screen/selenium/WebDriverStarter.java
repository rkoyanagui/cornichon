package br.com.rkoyanagui.cornichon.screen.selenium;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static java.util.Objects.nonNull;

import br.com.rkoyanagui.cornichon.config.WebDriverProperties;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.BrowserWebDriverContainer;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_factories.WebDriverFactory;
import br.com.rkoyanagui.cornichon.utils.Context;
import br.com.rkoyanagui.cornichon.utils.Key;
import java.net.MalformedURLException;
import java.net.URL;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
@Slf4j
public class WebDriverStarter {

  @Autowired
  private Context context;
  @Autowired
  private WebDriverProperties webDriverProperties;
  @Autowired
  private WebDriverFactory factory;

  public WebDriver initialiseWebDriver() {

    URL url = null;
    final String host = webDriverProperties.getServer().getHost();
    final int port = webDriverProperties.getServer().getPort();

    if (webDriverProperties.isRemote() && nonNull(host) && port > 0) {

      final String address = String.format("http://%s:%d/wd/hub", host, port);
      try {

        url = new URL(address);

      } catch (MalformedURLException e) {

        LOG.error("Unable to initialise Selenium WebDriver to address: " + address, e);
        throw new WebDriverFactoryException(e);
      }
    }
    return factory.getWebDriver(url, new DesiredCapabilities(), webDriverProperties);
  }

  public BrowserWebDriverContainer getFirstBrowserWebDriverContainer() {

    return context.<BrowserWebDriverContainer>get(Key.BROWSER_WEBDRIVER_CONTAINER)
        .orElseGet(() -> {
          BrowserWebDriverContainer newContainer =
              new BrowserWebDriverContainer(this.initialiseWebDriver());
          context.put(Key.BROWSER_WEBDRIVER_CONTAINER, newContainer);
          return newContainer;
        });
  }
}
