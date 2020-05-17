package br.com.rkoyanagui.cornichon.screen.selenium.driver_factories;

import br.com.rkoyanagui.cornichon.config.WebDriverProperties;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface WebDriverFactory {

  WebDriver getWebDriver(URL url, DesiredCapabilities capabilities, WebDriverProperties properties);
}
